package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCupon;

    private double porcentaje;
    /**
     * ! Esto se tiene que cambiar¡
     */
    private LocalDate fechaLimite;

    @ManyToOne
    private Usuario usuarioCupon;

    @ManyToOne
    private Compra compraCupon;

}
