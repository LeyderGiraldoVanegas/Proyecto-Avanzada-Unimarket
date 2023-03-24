package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Categoria {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
}
