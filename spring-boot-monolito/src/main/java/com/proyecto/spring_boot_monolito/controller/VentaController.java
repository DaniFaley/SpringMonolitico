package com.proyecto.spring_boot_monolito.controller;

import com.proyecto.spring_boot_monolito.model.Producto;
import com.proyecto.spring_boot_monolito.model.Venta;
import com.proyecto.spring_boot_monolito.repository.VentaRepository;
import com.proyecto.spring_boot_monolito.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta/")
public class VentaController {
    // Constructor
    private final VentaService ventaService;
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    // EndPoints

    // Ruta raiz
    @GetMapping
    public String home() {
        return "La api (Venta) esta corriendo correctamente ✅";
    }

    // CRUD

    // Crear un registro
    @PostMapping
    public ResponseEntity<?> createVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.createVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    // Eliminar un registro
    @DeleteMapping("{idVenta}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long idVenta) {
        ventaService.deleteVenta(idVenta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Modificar un registro
    @PutMapping("{idVenta}")
    public ResponseEntity<?> updateVenta(@PathVariable Long idVenta, @RequestBody Venta venta) {
        Venta ventaModificado = ventaService.updateVenta(idVenta, venta);
        if (ventaModificado == null) {
            return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(ventaModificado);
    }

    // Consultas: Para obtener datos

    // Obtener los registros de un usuario mediante su fkIdUsuario
    @GetMapping("usuario/{fkIdUsuario}")
    public ResponseEntity<?> getVentaFkIdUsuario(@PathVariable Long fkIdUsuario) {
        List<Venta> ventas = ventaService.findByFkIdUsuario(fkIdUsuario);
        return ResponseEntity.ok(ventas);
    }

    // Obtener todos los registros
    @GetMapping("todos")
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.findAllVentas();
        return ResponseEntity.ok(ventas);
    }

    // Obtener un registro en especifico mediante su id
    @GetMapping("id/{idVenta}")
    public ResponseEntity<?> getVentaId(@PathVariable Long idVenta) {
        Optional<Venta> ventas = ventaService.findById(idVenta);
        return ResponseEntity.ok(ventas);
    }
}
