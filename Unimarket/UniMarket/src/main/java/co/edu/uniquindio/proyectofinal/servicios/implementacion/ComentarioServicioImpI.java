package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.ComentarioDTO;
import co.edu.uniquindio.proyectofinal.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpI implements ComentarioServicio {
    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) {
        return 0;
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) {
        return null;
    }
}
