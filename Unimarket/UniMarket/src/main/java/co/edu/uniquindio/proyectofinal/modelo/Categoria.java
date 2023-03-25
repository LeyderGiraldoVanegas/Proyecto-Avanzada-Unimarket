package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class Categoria {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;

    @ManyToOne
    private List<Producto> productoList ;
}
