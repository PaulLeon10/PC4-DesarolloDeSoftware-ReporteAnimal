package com.reporteanimal.config;

import com.reporteanimal.patterns.facade.SistemaMascotasFacade;
import com.reporteanimal.repository.MascotaRepository;
import com.reporteanimal.repository.ReporteRepository;
import com.reporteanimal.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacadeConfig {

    @Bean
    public SistemaMascotasFacade sistemaMascotasFacade(
            MascotaRepository mascotaRepository,
            ReporteRepository reporteRepository,
            UsuarioRepository usuarioRepository
    ) {
        return new SistemaMascotasFacade(
                mascotaRepository,
                reporteRepository,
                usuarioRepository
        );
    }
}