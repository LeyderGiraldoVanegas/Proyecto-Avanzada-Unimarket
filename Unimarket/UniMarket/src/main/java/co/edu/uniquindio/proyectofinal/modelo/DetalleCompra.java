package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer unidades;

    private  double precioProducto;

    @ManyToOne
    private Compra compraList;

    @ManyToOne
    private Producto productoList;
}
