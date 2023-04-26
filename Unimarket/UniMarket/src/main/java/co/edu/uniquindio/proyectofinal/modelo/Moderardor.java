package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Moderardor extends Persona implements Serializable {

    @OneToMany(mappedBy = "moderardor")
    private List<Producto> productoList;
}
