package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private int  unidades;
    private float precio;
    private int codigoVendedor;

    private List<String> imagenes;
    private List<Categoria> categorias;
}
