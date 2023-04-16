package co.edu.uniquindio.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraDTO {

    private int codigoProducto;
    private int unidades;
    private float precio;
}
