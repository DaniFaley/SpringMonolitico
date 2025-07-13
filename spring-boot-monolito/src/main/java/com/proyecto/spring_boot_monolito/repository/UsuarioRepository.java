package com.proyecto.spring_boot_monolito.repository;

import com.proyecto.spring_boot_monolito.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUserName(String userName); // Para login o búsqueda por nombre de usuario
}
