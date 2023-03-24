package co.edu.uniquindio.proyectofinal.servicios;


import co.edu.uniquindio.proyectofinal.dto.CompraDTO;
import co.edu.uniquindio.proyectofinal.dto.CompraGetDTO;

import java.util.List;
public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);

    List<CompraGetDTO> listarCompras(int codigoUsuario);

    CompraGetDTO obtenerCompra(int codigoCompra);
}
