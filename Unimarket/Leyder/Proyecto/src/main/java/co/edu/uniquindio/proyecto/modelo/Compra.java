package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Compra {
    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(nullable = false)
    private LocalDateTime fecahaCreacion;
    @Column(nullable = false)
    private float valorTotal;
    @Column(nullable = false)
    private String medioPago;

    @ManyToOne
    private Usuario usuarioCompra;
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompraList;

    @OneToMany(mappedBy = "compraCupon")
    private List<Cupon> cuponList;

}
