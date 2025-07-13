package com.proyecto.spring_boot_monolito.repository;

import com.proyecto.spring_boot_monolito.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Metodos extras
    // Obtener una lista de ventas de un usuario por su id:
    List<Venta> findByFkIdUsuario(Long fkIdUsuario);
}
