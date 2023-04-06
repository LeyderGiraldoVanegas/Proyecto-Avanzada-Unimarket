package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.Activo;
import co.edu.uniquindio.proyectofinal.modelo.Categoria;
//import co.edu.uniquindio.proyectofinal.modelo.Activo;
import co.edu.uniquindio.proyectofinal.modelo.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {
    private int codigo;
    
   private Estado estado;

    private LocalDateTime fechaLimite;
    private String nombre;
    private String descripcion;
    private float  unidades;
    private float precio;
    private int codigoVendedor;
    private List<String> imagenes;
    private List<Categoria> categorias;


}
