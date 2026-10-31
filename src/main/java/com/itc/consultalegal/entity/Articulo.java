package com.itc.consultalegal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Articulo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero_articulo", nullable = false, length = 10)
    private String numeroArticulo;
    
    @Column(nullable = false, length = 255)
    private String titulo;
    
    @Column(name = "ley_relacionada", length = 100)
    private String leyRelacionada;
    
    @Column(columnDefinition = "TEXT")
    private String contenido;
    
    @Column(name = "tipo_codigo", length = 50)
    private String tipoCodigo;
    
    @Column(columnDefinition = "TEXT")
    private String penas;
    
    @Column(name = "modalidad", length = 500)
    private String modalidad;
    
    @Column(name = "modo", columnDefinition = "TEXT")
    private String modo;
}