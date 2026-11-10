package com.lavandus.app;

import com.lavandus.app.model.SolicitudServicio;
import com.lavandus.app.service.LavandusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LavandusServiceTest {

    private LavandusService service;

    @BeforeEach
    void setUp() {
        service = new LavandusService();
    }

    @Test
    @DisplayName("Debe registrar exitosamente una solicitud con mas de 50 kg")
    void testCrearSolicitudExitosa() {
        SolicitudServicio sol = new SolicitudServicio(null, "Hotel Interplaza", 120.0, "Hoteleria", LocalDate.now());
        SolicitudServicio creada = service.crearSolicitud(sol);

        assertNotNull(creada.getId());
        assertEquals("Registrada", creada.getEstado());
        assertEquals(120.0 * 1200.0, creada.getTotalLiquidado());
    }

    @Test
    @DisplayName("Debe lanzar excepcion si la solicitud industrial es menor a 50 kg")
    void testCrearSolicitudFallaPorKilosInsuficientes() {
        SolicitudServicio solInvalida = new SolicitudServicio(null, "Lavanderia Pequena", 30.0, "Hoteleria", LocalDate.now());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.crearSolicitud(solInvalida);
        });

        assertTrue(exception.getMessage().contains("volumen mínimo"));
    }

    @Test
    @DisplayName("Debe avanzar correctamente el estado operativo de la solicitud")
    void testAvanzarEstado() {
        SolicitudServicio sol = new SolicitudServicio(null, "Clinica Velez", 200.0, "Hospitalario", LocalDate.now());
        SolicitudServicio creada = service.crearSolicitud(sol);

        SolicitudServicio enLavado = service.avanzarEstado(creada.getId());
        assertEquals("En Lavado", enLavado.getEstado());

        SolicitudServicio enSecado = service.avanzarEstado(enLavado.getId());
        assertEquals("En Secado/Planchado", enSecado.getEstado());
    }
}