package com.proyecto.spring_boot_monolito.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

// Genera los metodos: getters y setters de los atributos
@Data
// Defines la clase como una tabla en la base de datos
@Entity
// Nombre de la tabla
@Table(name = "producto")
public class Producto {
    // Id: Unico e incrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    // Columnas de la tabla
    @Column(name = "fk_idusuario", nullable = false)
    private Long fkIdUsuario;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "fecha_registro",nullable = false)
    private LocalDateTime fechaRegistro;
    @Column(name = "precio", nullable = false, length = 10)
    private Double precio;
    @Column(name = "stock", nullable = false, length = 10)
    private Integer stock;
}
