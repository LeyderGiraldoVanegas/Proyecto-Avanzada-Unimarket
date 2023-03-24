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
public class Imagen implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String ruta;

    @Column(nullable = false)
    private String idImagen;


}
