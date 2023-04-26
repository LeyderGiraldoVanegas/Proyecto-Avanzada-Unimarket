package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable  {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;

    private LocalDate fechaCreacion;
    private double valorTotal;

    private MedioPago medioPago;

    @ManyToOne
    private Usuario usuarioList;

    @OneToMany(mappedBy = "compraList")
    private List<DetalleCompra> detalleCompraList;

}
