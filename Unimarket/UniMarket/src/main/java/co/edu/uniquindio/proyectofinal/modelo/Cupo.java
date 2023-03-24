package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;
    private double porcentaje;
}
