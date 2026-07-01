package com.reporteanimal.patterns.facade;

import com.reporteanimal.enums.IntencionBusqueda;
import com.reporteanimal.model.Mascota;
import com.reporteanimal.model.Reporte;
import com.reporteanimal.model.Usuario;
import com.reporteanimal.patterns.factory.IntencionBusquedaFactory;
import com.reporteanimal.patterns.strategy.BusquedaStrategy;
import com.reporteanimal.patterns.template.ProcesadorReporte;
import com.reporteanimal.repository.MascotaRepository;
import com.reporteanimal.repository.ReporteRepository;
import com.reporteanimal.repository.UsuarioRepository;

import java.util.List;

public class SistemaMascotasFacade {

    private final MascotaRepository mascotaRepository;
    private final ReporteRepository reporteRepository;
    private final UsuarioRepository usuarioRepository;

    public SistemaMascotasFacade(
            MascotaRepository mascotaRepository,
            ReporteRepository reporteRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.mascotaRepository = mascotaRepository;
        this.reporteRepository = reporteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Reporte registrarReporte(ProcesadorReporte procesador, Reporte reporte) {
        procesador.procesar(reporte);
        return reporte;
    }

    public List<Mascota> buscarMascotas(
            IntencionBusqueda intencion,
            List<Mascota> mascotas,
            String criterio
    ) {
        BusquedaStrategy strategy = IntencionBusquedaFactory.crear(intencion);
        return strategy.buscar(mascotas, criterio);
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Reporte guardarReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}