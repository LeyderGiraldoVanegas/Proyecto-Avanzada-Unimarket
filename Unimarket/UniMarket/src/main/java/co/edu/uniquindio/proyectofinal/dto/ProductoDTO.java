package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.Categoria;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    @Length(max = 140)
    @NotBlank
    @NotNull
    private String nombre;
    @NotBlank
    @NotNull
    private String descripcion;
    @PositiveOrZero
    private int  unidades;
    @PositiveOrZero
    private int cantidad;
    @PositiveOrZero
    private float precio;
    @Positive
    private int codigoVendedor;

    //private  boolean activo ;

     private List<String> imagenes;

    private List<Categoria> categorias;
}
