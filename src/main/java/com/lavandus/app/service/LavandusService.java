package com.lavandus.app.service;

import com.lavandus.app.model.SolicitudServicio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LavandusService {

    private final Map<Long, SolicitudServicio> baseDatosEnMemoria = new LinkedHashMap<>();
    private final AtomicLong contadorId = new AtomicLong(1000);

    public LavandusService() {
        // Datos semilla iniciales para pruebas del MVP
        crearSolicitud(new SolicitudServicio(contadorId.incrementAndGet(), "Gran Hotel Panorama", 350.0, "Hoteleria", LocalDate.now().plusDays(1)));
        crearSolicitud(new SolicitudServicio(contadorId.incrementAndGet(), "Sanatorio San Jeronimo", 520.0, "Hospitalario", LocalDate.now().plusDays(2)));
    }

    public List<SolicitudServicio> listarTodas() {
        return new ArrayList<>(baseDatosEnMemoria.values());
    }

    public SolicitudServicio crearSolicitud(SolicitudServicio nuevaSolicitud) {
        if (nuevaSolicitud.getKilosEstimados() < 50.0) {
            throw new IllegalArgumentException("El volumen mínimo para retiro industrial es de 50 Kilogramos.");
        }
        Long idGenerado = contadorId.incrementAndGet();
        nuevaSolicitud.setId(idGenerado);
        nuevaSolicitud.setEstado("Registrada");
        baseDatosEnMemoria.put(idGenerado, nuevaSolicitud);
        return nuevaSolicitud;
    }

    public SolicitudServicio avanzarEstado(Long id) {
        SolicitudServicio sol = baseDatosEnMemoria.get(id);
        if (sol == null) {
            throw new NoSuchElementException("Solicitud no encontrada con ID: " + id);
        }

        switch (sol.getEstado()) {
            case "Registrada":
                sol.setEstado("En Lavado");
                break;
            case "En Lavado":
                sol.setEstado("En Secado/Planchado");
                break;
            case "En Secado/Planchado":
                sol.setEstado("Lista para Entrega");
                break;
            case "Lista para Entrega":
                sol.setEstado("Entregada y Facturada");
                break;
            default:
                break;
        }
        return sol;
    }
}