package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.ComentarioDTO;
import co.edu.uniquindio.proyectofinal.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Comentario;
import co.edu.uniquindio.proyectofinal.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.ComentarioServicio;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.ProductoServicio;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServicioImpI implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception{
        Comentario comentario = new Comentario();
        comentario.setCodigoComentario(comentarioDTO.getCodigoUsuario());
        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setFechaCreacion(LocalDateTime.now());
        comentario.setProductoComentario(productoServicio.obtenerProducto(comentarioDTO.getCodigoProducto()));
        comentario.setUsuarioComentario(usuarioServicio.obtenerComentario(comentarioDTO.getCodigoUsuario()));
        return comentarioRepo.save(comentario).getCodigoComentario();
    }


    @Override
    public ComentarioGetDTO actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO) throws Exception {
        validarExiste(codigoComentario);
        Comentario comentario = convertir(comentarioDTO);
        comentario.setCodigoComentario(codigoComentario);
        return convertir(comentarioRepo.save(comentario));
    }

    private Comentario convertir(ComentarioDTO comentarioDTO) throws Exception {

        Comentario comentario = new Comentario();
        comentario.setCodigoComentario(comentarioDTO.getCodigoComentario());
        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setFechaCreacion(LocalDateTime.now());
        comentario.setProductoComentario(productoServicio.obtenerProducto(comentarioDTO.getCodigoProducto()));
        comentario.setUsuarioComentario(usuarioServicio.obtenerComentario(comentarioDTO.getCodigoUsuario()));
        return comentario;
    }

    private ComentarioGetDTO convertir(Comentario comentario) {

        ComentarioGetDTO comentarioDTO = new ComentarioGetDTO(
                comentario.getCodigoComentario(),
                comentario.getMensaje(),
                comentario.getFechaCreacion(),
                comentario.getProductoComentario(),
                comentario.getUsuarioComentario());
        return comentarioDTO;

    }

    private void validarExiste(int codigoComentario) throws Exception {
        boolean existe = comentarioRepo.existsById(codigoComentario);

        if( !existe ){
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún comentario");
        }
    }

    @Override
    public int eliminiarComentario(int codigoComentario) throws Exception {

        validarExiste(codigoComentario);
        comentarioRepo.deleteById(codigoComentario);
        return codigoComentario;
    }

    @Override
    public ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception {
        return convertir(obtener(codigoComentario));
    }

    @Override
    public Comentario obtener(int codigoComentario) throws Exception {
        Optional<Comentario> comentario = comentarioRepo.findById(codigoComentario);

        if (comentario.isEmpty()){
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún comentario");
        }
        return comentario.get();

    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) {

        //List<Comentario> lista = comentarioRepo.obtenerComentarios(codigoProducto);
        //List<ComentarioGetDTO> respuesta = new ArrayList<>();

        //for (Comentario c : lista ) {
            //respuesta.add(convertir(c));
        //}
        //return respuesta;
        return null;
    }

}
