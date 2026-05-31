package com.enlatadosmg.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    public WebConfig(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor)
                .addPathPatterns(
                        "/usuarios/**",
                        "/clientes/**",
                        "/reportes/**",
                        "/vehiculos/**",
                        "/pedidos/**",
                        "/repartidores/**",
                        "/cajas/**"
                )
                .excludePathPatterns(
                        "/usuarios/cargar-csv"
                );
    }
}
