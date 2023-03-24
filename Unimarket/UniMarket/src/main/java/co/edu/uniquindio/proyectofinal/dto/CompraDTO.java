package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private int codigoUsuario;
    private MedioPago medioPago;
    private List<DetalleCompraDTO> detalleCompraDTO;
}
