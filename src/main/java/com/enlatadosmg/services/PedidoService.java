package com.enlatadosmg.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.enlatadosmg.models.Caja;
import com.enlatadosmg.models.Cliente;
import com.enlatadosmg.models.Pedido;
import com.enlatadosmg.models.PedidoRequest;
import com.enlatadosmg.models.Repartidor;
import com.enlatadosmg.models.Vehiculo;
import com.enlatadosmg.structures.ColaPedidos;
import com.enlatadosmg.structures.ListaEnlazadaPedidos;

@Service
public class PedidoService {

    private ColaPedidos colaPedidos;
    private ListaEnlazadaPedidos listaPedidos;
    private int siguienteNumeroPedido;

    private final ClienteService clienteService;
    private final RepartidorService repartidorService;
    private final VehiculoService vehiculoService;
    private final PilaCajasService pilaCajasService;

    public PedidoService(
            ClienteService clienteService,
            RepartidorService repartidorService,
            VehiculoService vehiculoService,
            PilaCajasService pilaCajasService) {

        this.clienteService = clienteService;
        this.repartidorService = repartidorService;
        this.vehiculoService = vehiculoService;
        this.pilaCajasService = pilaCajasService;

        colaPedidos = new ColaPedidos();
        listaPedidos = new ListaEnlazadaPedidos();
        siguienteNumeroPedido = 1;
    }

    public String crearPedido(PedidoRequest request) {
        if (request.getCantidadCajas() <= 0) {
            return "La cantidad de cajas debe ser mayor a cero";
        }

        Cliente cliente = clienteService.buscarCliente(request.getCuiCliente());

        if (cliente == null) {
            return "Cliente no encontrado";
        }

        Repartidor repartidor = repartidorService.sacarRepartidor();

        if (repartidor == null) {
            return "No hay repartidores disponibles";
        }

        Vehiculo vehiculo = vehiculoService.sacarVehiculo();

        if (vehiculo == null) {
            repartidorService.agregarRepartidor(repartidor);
            return "No hay vehiculos disponibles";
        }

        Pedido pedido = new Pedido(
                siguienteNumeroPedido,
                request.getOrigen(),
                request.getDestino(),
                obtenerFechaActual(),
                "Pendiente",
                cliente,
                repartidor,
                vehiculo
        );

        int cajasAsignadas = 0;

        for (int i = 0; i < request.getCantidadCajas(); i++) {
            Caja caja = pilaCajasService.sacarCaja();

            if (caja == null) {
                break;
            }

            pedido.getCajas().insertar(caja);
            cajasAsignadas++;
        }

        if (cajasAsignadas < request.getCantidadCajas()) {
            repartidorService.agregarRepartidor(repartidor);
            vehiculoService.agregarVehiculo(vehiculo);

            for (int i = 0; i < cajasAsignadas; i++) {
                Caja cajaDevuelta = pedido.getCajas().buscarPorPosicion(i);
                if (cajaDevuelta != null) {
                    pilaCajasService.agregarCaja(cajaDevuelta);
                }
            }

            return "No hay suficientes cajas en almacén";
        }

        pedido.setNumeroCajas(cajasAsignadas);

        colaPedidos.encolar(pedido);
        listaPedidos.insertar(pedido);
        siguienteNumeroPedido++;

        return "Pedido creado correctamente con número: " + pedido.getNumeroPedido();
    }

    public void agregarPedido(Pedido pedido) {
        colaPedidos.encolar(pedido);
        listaPedidos.insertar(pedido);
    }

    public Pedido atenderPedido() {
        return colaPedidos.desencolar();
    }

    public Pedido verSiguiente() {
        return colaPedidos.verFrente();
    }

    public String listarPedidos() {
        return listaPedidos.listarPedidos();
    }

    public Pedido buscarPedido(int numeroPedido) {
        return listaPedidos.buscar(numeroPedido);
    }

    public boolean completarPedido(int numeroPedido) {
        Pedido pedido = listaPedidos.buscar(numeroPedido);

        if (pedido == null) {
            return false;
        }

        if ("Completado".equalsIgnoreCase(pedido.getEstado())) {
            return true;
        }

        pedido.setEstado("Completado");

        if (pedido.getRepartidor() != null) {
            repartidorService.agregarRepartidor(pedido.getRepartidor());
        }

        if (pedido.getVehiculo() != null) {
            vehiculoService.agregarVehiculo(pedido.getVehiculo());
        }

        return true;
    }

    public String verCajasPedido(int numeroPedido) {
        Pedido pedido = listaPedidos.buscar(numeroPedido);

        if (pedido == null) {
            return "Pedido no encontrado";
        }

        return pedido.getCajas().listarCajas();
    }

    public Cliente verClientePedido(int numeroPedido) {
        Pedido pedido = listaPedidos.buscar(numeroPedido);

        if (pedido == null) {
            return null;
        }

        return pedido.getCliente();
    }

    public Repartidor verRepartidorPedido(int numeroPedido) {
        Pedido pedido = listaPedidos.buscar(numeroPedido);

        if (pedido == null) {
            return null;
        }

        return pedido.getRepartidor();
    }

    public Vehiculo verVehiculoPedido(int numeroPedido) {
        Pedido pedido = listaPedidos.buscar(numeroPedido);

        if (pedido == null) {
            return null;
        }

        return pedido.getVehiculo();
    }

    public String generarDotPedidos() {
        return listaPedidos.generarDot();
    }

    private String obtenerFechaActual() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formato);
    }
}