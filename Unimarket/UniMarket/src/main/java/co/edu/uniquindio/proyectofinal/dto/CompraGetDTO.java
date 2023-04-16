package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.Cupon;
import co.edu.uniquindio.proyectofinal.modelo.DetalleCompra;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CompraGetDTO {
    private int codigoCompra;
    private LocalDateTime fecha;
    private float valorTotal;
    private String metodoPago;
    private Usuario codigoUsuario;
    private List<DetalleCompra> detalleCompraList;
    private List<Cupon>  cuponList;
}
