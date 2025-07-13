package com.proyecto.spring_boot_monolito.service;

import com.proyecto.spring_boot_monolito.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    // Crear registro
    Producto createProducto(Producto producto);

    // Eliminar registro
    void deleteProducto(Long idProducto);

    // Modificar registro
    Producto updateProducto(Long idProducto, Producto producto);

    // Obtener los registros de un usuario mediante su idUsuario
    List<Producto> findProductoByUsuario(Long idUsuario);

    // Obtener los registros de un usuario mediante su idUsuario: En orde mas reciente a antigua
    Optional<Producto> findProductoById(Long idProducto);

    // Obtener todos los registros
    List<Producto> findAllProductos();
}
