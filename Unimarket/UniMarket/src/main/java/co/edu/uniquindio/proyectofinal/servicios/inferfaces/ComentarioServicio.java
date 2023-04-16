package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.ComentarioDTO;
import co.edu.uniquindio.proyectofinal.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Comentario;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    ComentarioGetDTO actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO)throws Exception;

    int eliminiarComentario(int codigoComentario)throws Exception;

    ComentarioGetDTO obtenerComentario(int codigoComentario)throws Exception;

    Comentario obtener(int codigoComentario)throws Exception;

    List<ComentarioGetDTO> listarComentarios(int codigoProducto);

}
