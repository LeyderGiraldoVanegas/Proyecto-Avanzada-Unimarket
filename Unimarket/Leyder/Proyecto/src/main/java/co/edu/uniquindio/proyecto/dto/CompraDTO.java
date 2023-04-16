package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private int codigoUsuario;
    private List<DetalleCompraDTO> detalleCompraDTOList;


}
