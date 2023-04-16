package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.Cupon;
import co.edu.uniquindio.proyectofinal.modelo.DetalleCompra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private int codigoCompra;
    private float valorTotal;
    private String metodoPago;
    private List<DetalleCompra> detalleCompraList;
    private List<Cupon>  cuponList;

}
