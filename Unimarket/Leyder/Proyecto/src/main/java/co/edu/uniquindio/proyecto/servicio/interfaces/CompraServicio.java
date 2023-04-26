package co.edu.uniquindio.proyecto.servicio.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO)throws Exception;

    CompraGetDTO actualizarCompra(int codigoCompra, CompraDTO compraDTO)throws Exception;

    int eliminiarCompra(int codigoCompra)throws Exception;

    Compra obtenerCompra(int codigoCompra)throws Exception;

    List<CompraGetDTO> listarCompras() throws Exception;

}
