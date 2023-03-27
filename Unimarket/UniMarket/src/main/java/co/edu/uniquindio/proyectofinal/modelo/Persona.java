package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import javax.swing.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
    private String nombre;
    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private List<Usuario> usuarioList;

    @OneToOne
    private List<Moderardor> moderardorList;
}
