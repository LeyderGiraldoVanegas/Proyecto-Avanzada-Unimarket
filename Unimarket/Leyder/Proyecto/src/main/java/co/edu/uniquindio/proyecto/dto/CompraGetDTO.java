package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CompraGetDTO {
    private int codigo;
    private LocalDateTime fecha;
    private float valorTotal;
    private int codigoUsuario;
    //private int metodoPago;
    private List<DetalleCompraDTO> detalleCompraDTOList;
}
