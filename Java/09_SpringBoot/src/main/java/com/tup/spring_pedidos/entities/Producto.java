package com.tup.spring_pedidos.entities;
import java.util.Objects;
import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "nombre", callSuper = false) // compara productos por nombre
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity //TP JPA
@Table(name = "productos")
public class Producto extends Base {

    @Column(unique = true)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(length = 500)
    private String descripcion;

    @Column
    private int stock;

    private String imagen;

    @Column
    private boolean disponible;

}
