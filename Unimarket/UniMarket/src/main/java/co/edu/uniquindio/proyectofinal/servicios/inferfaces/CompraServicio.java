package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.CompraDTO;
import co.edu.uniquindio.proyectofinal.dto.CompraGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Compra;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO)throws Exception;

    CompraGetDTO actualizarCompra(int codigoCompra, CompraDTO compraDTO)throws Exception;

    int eliminiarCompra(int codigoCompra)throws Exception;

    Compra obtenerCompra(int codigoCompra)throws Exception;


    List<CompraGetDTO> listarCompras(int codigoUsuario);


}
