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
public class Usuario extends Persona implements Serializable  {

    @Id
    @EqualsAndHashCode.Include
    private Integer cedula;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;


    @OneToMany
    private List<Cupo> cupoList;

    @OneToMany
    private List<Compra> compraLista;

    @OneToMany
    private List<Comentario> comentarioList;

    @OneToMany
    private List<Producto> productoListaFaorito;

    @OneToOne
    private List<Persona> personasList;

}
