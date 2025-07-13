package com.proyecto.spring_boot_monolito.service;

import com.proyecto.spring_boot_monolito.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByUserName(String userName);

    Usuario save(Usuario usuario);

    void deleteById(Long id);
}
