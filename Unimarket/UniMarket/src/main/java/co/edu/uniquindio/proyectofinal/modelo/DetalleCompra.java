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
    private  double precioProducto;

    @OneToMany
    @Column(nullable = false)
    private List<Compra> compraList;

    @OneToMany
    @Column(nullable = false)
    private List<Producto> productoList;
}
