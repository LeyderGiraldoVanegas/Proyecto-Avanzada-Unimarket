package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupo implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;

    private double porcentaje;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @ManyToOne
    private List<Usuario> usuarioList;
}
