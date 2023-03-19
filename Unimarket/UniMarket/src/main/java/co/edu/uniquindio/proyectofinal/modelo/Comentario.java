package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;
@Entity
public class Comentario {
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    private Integer codigo;
    private LocalDate FechaCreacion;

 //   private List<Usuario> usuarioList;
  //  private List<Producto> productoList;
}
