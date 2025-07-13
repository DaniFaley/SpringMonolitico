package com.proyecto.spring_boot_monolito.controller;

import com.proyecto.spring_boot_monolito.model.Usuario;
import com.proyecto.spring_boot_monolito.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    // Obtener usuario por nombre de usuario
    @GetMapping("/buscar/{username}")
    public Optional<Usuario> getUsuarioByUsername(@PathVariable String username) {
        return usuarioService.findByUserName(username);
    }

    // Crear nuevo usuario
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // encripta la pass
        usuario.setFechaRegistro(LocalDateTime.now());
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}