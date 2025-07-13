package com.proyecto.spring_boot_monolito.service;

import com.proyecto.spring_boot_monolito.model.Producto;
import com.proyecto.spring_boot_monolito.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    // Constructor
    private final ProductoRepository productoRepository;
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    // Crear registro
    @Override
    public Producto createProducto(Producto producto) {
        producto.setFechaRegistro(LocalDateTime.now());
        return productoRepository.save(producto);
    }
    // Eliminar registro
    @Override
    public void deleteProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
    // Modificar registro
    @Override
    public Producto updateProducto(Long idProducto, Producto producto) {
        // Buscar registro por su Id
        Producto productoExistente = productoRepository.findById(idProducto).orElse(null);
        // Si no existe el registro retornara null
        if (productoExistente == null) {
            return null;
        }
        // Actualizar campos del registro
        productoExistente.setFkIdUsuario(producto.getFkIdUsuario());
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setFechaRegistro(producto.getFechaRegistro());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        // Guardar cambios y retornar registro actualizado
        return productoRepository.save(productoExistente);
    }
    // Obtener los registros de un usuario mediante su fkIdUsuario
    @Override
    public List<Producto> findProductoByUsuario(Long fkIdUsuario) {
        return productoRepository.findByFkIdUsuario(fkIdUsuario);
    }

    // Obtener un registro en especifico mediante su id
    @Override
    public Optional<Producto> findProductoById(Long idProducto) {
        return productoRepository.findById(idProducto);
    }
    // Obtener todos los registros
    @Override
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }
}
