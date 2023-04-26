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
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable  {

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;


    @OneToMany(mappedBy = "usuarioList")
    private List<Cupo> cupoList;

    @OneToMany(mappedBy = "usuarioList")
    private List<Compra> compraLista;

    @OneToMany(mappedBy = "usuarioList")
    private List<Comentario> comentarioList;

    @ManyToMany
    private List<Producto> productoListaFaorito;


}
