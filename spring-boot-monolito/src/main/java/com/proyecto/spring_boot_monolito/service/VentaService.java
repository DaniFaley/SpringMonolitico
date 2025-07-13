package com.proyecto.spring_boot_monolito.service;

import com.proyecto.spring_boot_monolito.model.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    // Crear registro
    Venta createVenta(Venta venta);

    // Eliminar registro
    void deleteVenta(Long idVenta);

    // Modificar registro
    Venta updateVenta(Long idVenta, Venta venta);

    // Obtener los registros de un usuario mediante su fkIdUsuario
    List<Venta> findByFkIdUsuario(Long fkIdUsuario);

    // Obtener un registro en especifico mediante su id
    Optional<Venta> findById(Long idVenta);

    // Obtener todos los registros
    List<Venta> findAllVentas();
}
