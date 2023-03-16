package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable  {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String codigo;

    private LocalDate fechaCreacion;
    private double valorTotal;

    @ElementCollection
    @Column(nullable = false)
    private List<MedioPago> medioPago;
    @OneToMany
    @Column(nullable = false)
    private List<Usuario> usuarioList;

}
