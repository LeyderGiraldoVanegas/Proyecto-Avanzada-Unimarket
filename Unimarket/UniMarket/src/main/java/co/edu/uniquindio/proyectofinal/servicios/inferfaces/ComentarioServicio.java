package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.ComentarioDTO;
import co.edu.uniquindio.proyectofinal.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentarios(int codigoProducto);

}
