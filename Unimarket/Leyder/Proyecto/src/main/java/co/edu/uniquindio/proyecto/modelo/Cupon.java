package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private Integer codigo;

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
