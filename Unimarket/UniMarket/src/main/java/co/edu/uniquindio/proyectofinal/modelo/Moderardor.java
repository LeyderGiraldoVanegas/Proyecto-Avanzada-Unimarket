package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Moderardor extends Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    @OneToOne
    private List<Usuario> usuarioList;

    @OneToMany
    private List<Producto> productoList;
}
