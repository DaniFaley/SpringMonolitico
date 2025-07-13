package com.proyecto.spring_boot_monolito.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

// Genera los metodos: getters y setters de los atributos
@Data
// Defines la clase como una tabla en la base de datos
@Entity
// Nombre de la tabla
@Table(name = "venta")
public class Venta {
    // Id: Unico e incrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    // FK's
    @Column(name = "fk_idproducto", nullable = false)
    private Long fkIdProducto;
    @Column(name = "fk_idusuario", nullable = false)
    private Long fkIdUsuario;
    // Columnas
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta;
    @Column(name = "cantidad", nullable = false)
    private Double cantidad;
    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;
}
