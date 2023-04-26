package co.edu.uniquindio.proyectofinal.modelo;

import  jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

   @Column(nullable = false, length = 150)
   private String nombre;

   @Column(nullable = false)
   private String descripcion;

   @Column(nullable = false)
   private  float precio;

   @Column(nullable = false)
   private int cantidad;

   @ElementCollection
   @Column(nullable = false)
   private List<String> archivo;

   @Column(nullable = false)
   private int numeroFavorito;

   @Column(nullable = false)
   private LocalDateTime fechaCreado;

   @Column(nullable = false)
   private LocalDateTime fechaLimite; //LocalDateTime

   @Column(nullable = false)
   private int numeroLike;

   @Column(nullable = false)
   private Estado estados;

   @ManyToMany(mappedBy = "productoListaFaorito")
   private List<Usuario> favoritos;

   @ManyToOne
   private Moderardor moderardor;

   @ManyToOne
   private Usuario usuario;

   @OneToMany(mappedBy = "productoList")
   private List<Comentario> comentarioList;

   @OneToMany(mappedBy = "productoList")
   private List<Categoria> categorias;

   @OneToMany(mappedBy = "productoList")
   private List<DetalleCompra> detalleCompras;


}
