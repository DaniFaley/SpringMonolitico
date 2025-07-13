package com.proyecto.spring_boot_monolito.controller;

import com.proyecto.spring_boot_monolito.model.Producto;
import com.proyecto.spring_boot_monolito.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto/")
public class ProductoController {
    // Constructor
    private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // EndPoints

    // Ruta Raiz
    @GetMapping
    public String home() {
        return "La api (Producto) esta corriendo correctamente ✅";
    }

    // CRUD

    // Crear registro
    @PostMapping
    public ResponseEntity<?> createProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.createProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    // Eliminar registro
    @DeleteMapping("{idProducto}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long idProducto) {
        productoService.deleteProducto(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Modificar registro
    @PutMapping("{idProducto}")
    public ResponseEntity<?> updateProducto(@PathVariable Long idProducto, @RequestBody Producto producto) {
        Producto productoModificado = productoService.updateProducto(idProducto, producto);
        if (productoModificado == null) {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(productoModificado);
    }

    // Consultas: Para obtener datos

    // Obtener los registros de un usuario mediante su idUsuario
    @GetMapping("usuario/{fkIdUsuario}")
    public ResponseEntity<?> getProductofkIdUsuario(@PathVariable Long fkIdUsuario) {
        List<Producto> producto = productoService.findProductoByUsuario(fkIdUsuario);
        return ResponseEntity.ok(producto);
    }

    // Obtener todos los registros
    @GetMapping("todos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> producto = productoService.findAllProductos();
        return ResponseEntity.ok(producto);
    }

    // Obtener un registro en especifico mediante su id
    @GetMapping("id/{idProducto}")
    public ResponseEntity<?> getProductoId(@PathVariable Long idProducto) {
        Optional<Producto> producto = productoService.findProductoById(idProducto);
        return ResponseEntity.ok(producto);
    }
}
