	package com.enlatadosmg.controllers;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;
	
	import com.enlatadosmg.models.Cliente;
	import com.enlatadosmg.services.ClienteService;
	
	@RestController
	@RequestMapping("/clientes")
	public class ClienteController {
	
	    @Autowired
	    private ClienteService clienteService;
	
	    @PostMapping
	    public String insertarCliente(@RequestBody Cliente cliente) {
	
	        clienteService.insertarCliente(cliente);
	
	        return "Cliente insertado correctamente";
	    }
	
	    @GetMapping("/{cui}")
	    public Cliente buscarCliente(@PathVariable long cui) {
	
	        return clienteService.buscarCliente(cui);
	    }
	    
	    @GetMapping
	    public String listarClientes() {
	        return clienteService.listarClientes();
	    }
	}