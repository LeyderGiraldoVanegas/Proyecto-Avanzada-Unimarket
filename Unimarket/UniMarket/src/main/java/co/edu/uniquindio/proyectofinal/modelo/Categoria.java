package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;

    @ManyToOne
    private Producto productoList ;
}
