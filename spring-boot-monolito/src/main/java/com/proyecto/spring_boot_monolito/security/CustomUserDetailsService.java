package com.proyecto.spring_boot_monolito.security;

import com.proyecto.spring_boot_monolito.model.Usuario;
import com.proyecto.spring_boot_monolito.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new User(
                usuario.getUserName(),
                usuario.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name()))
        );
    }
}
