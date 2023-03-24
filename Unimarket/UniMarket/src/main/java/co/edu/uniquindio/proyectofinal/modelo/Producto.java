package co.edu.uniquindio.proyectofinal.modelo;

import  jakarta.persistence.*;
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
public class Producto implements Serializable {
   @Id
   @Column(nullable = false)
   @EqualsAndHashCode.Include
   private Integer codigo;

   @Column(nullable = false)
   private int unidades;

   @Column(nullable = false)
   private String descripcion;

   @Column(nullable = false)
   private  double precio;

   @Column(nullable = false)
   private String archivo;

   @Column(nullable = false)
   private String fechaCreado;


   @Column(nullable = false)
   private LocalDate fechaLimite;

   @Column(nullable = false)
   private LocalDate codigoVendedor;

   private int numeroLike;

   @ManyToMany
   private List<Usuario> favoritos;

   @ElementCollection
   @Column(nullable = false)
   private List<Estado> estados;


}
