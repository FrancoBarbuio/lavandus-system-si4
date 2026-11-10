package com.lavandus.app.controller;

import com.lavandus.app.model.SolicitudServicio;
import com.lavandus.app.service.LavandusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LavandusController {

    @Autowired
    private LavandusService service;

    // Endpoint de Login Simulado requerido por el Sprint 0
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String usuario = credentials.get("username");
        String pass = credentials.get("password");

        if ("admin@lavandus.com".equals(usuario) && "Admin123*".equals(pass)) {
            return ResponseEntity.ok(Map.of(
                    "token", "jwt-token-lavandus-authorized-secret-2026",
                    "role", "GERENTE_OPERACIONES",
                    "nombre", "Franco Barbuio"
            ));
        } else if ("cliente@hospital.com".equals(usuario) && "Cliente123*".equals(pass)) {
            return ResponseEntity.ok(Map.of(
                    "token", "jwt-token-lavandus-cliente-2026",
                    "role", "CLIENTE_CORP",
                    "nombre", "Hospital Central"
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("mensaje", "Credenciales invalidas"));
    }

    @GetMapping("/solicitudes")
    public List<SolicitudServicio> getSolicitudes() {
        return service.listarTodas();
    }

    @PostMapping("/solicitudes")
    public ResponseEntity<?> registrar(@RequestBody SolicitudServicio solicitud) {
        try {
            SolicitudServicio creada = service.crearSolicitud(solicitud);
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }

    @PutMapping("/solicitudes/{id}/avanzar")
    public ResponseEntity<?> avanzar(@PathVariable Long id) {
        try {
            SolicitudServicio actualizada = service.avanzarEstado(id);
            return ResponseEntity.ok(actualizada);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
        }
    }
}