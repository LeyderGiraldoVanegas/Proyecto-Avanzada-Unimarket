package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario {
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    private Integer codigo;

    @Column(nullable = false, length = 150)
    private String mesnsaje;

    @Column(nullable = false)
    private LocalDate FechaCreacion;

    @ManyToOne
    private List<Usuario> usuarioList;
    @ManyToOne
    private List<Producto> productoList;
}
