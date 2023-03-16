package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupo implements Serializable {
    @Id
    private String codigo;
    private double porcentaje;
}
