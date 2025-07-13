package com.proyecto.spring_boot_monolito.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    // Id con auto-incremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    // Columnas
    // ENUM de rol almacenado como String en la BD
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false, length = 20)
    private Rol rol;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "user_name", nullable = false,length = 20)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
}
