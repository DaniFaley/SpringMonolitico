package com.proyecto.spring_boot_monolito.repository;

import com.proyecto.spring_boot_monolito.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Metodos extras
    // Obtener una lista de productos de un usuario por su id:
    List<Producto> findByFkIdUsuario(Long fkIdUsuario);
}
