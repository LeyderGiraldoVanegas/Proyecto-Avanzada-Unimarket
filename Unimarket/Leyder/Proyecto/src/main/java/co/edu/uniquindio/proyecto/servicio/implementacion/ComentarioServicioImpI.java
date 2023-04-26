package co.edu.uniquindio.proyecto.servicio.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicio.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicio.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicio.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServicioImpI implements ComentarioServicio {

    private final ProductoServicio productoServicio;
    private final UsuarioServicio usuarioServicio;
    private final ComentarioRepo comentarioRepo;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        //validarExiste(comentarioDTO.);
        Comentario comentario = convertirDTOaComentario(comentarioDTO);
        return comentarioRepo.save(comentario).getCodigo();
    }

    private Comentario convertirDTOaComentario(ComentarioDTO comentarioDTO) throws Exception {

        Usuario usuario = usuarioServicio.obtener(comentarioDTO.getCodigoUsuario());
        Producto producto = productoServicio.obtener(comentarioDTO.getCodigoProducto());
        LocalDateTime fechaCreacion = LocalDateTime.now();

        if (usuario == null){
            throw new Exception("El código "+usuario.getCodigo()+" no está asociado a ningún usuario");
        }
        if (producto == null){
            throw new Exception("El código "+producto.getCodigo()+" no está asociado a ningún producto");
        }
        Comentario comentario = new Comentario();
        comentario.setProductoComentario(producto);
        comentario.setUsuarioComentario(usuario);
        comentario.setMensaje(comentarioDTO.getMenasaje());
        comentario.setFechaCreacion(fechaCreacion);

        return comentario;
    }

    @Override
    public ComentarioGetDTO actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO) throws Exception {
        validarExiste(codigoComentario);

        Comentario comentario = convertirDTOaComentario(comentarioDTO);
        comentario.setCodigo(codigoComentario);

        return convertirComentarioaGetDTO( comentarioRepo.save(comentario) );
    }

    private ComentarioGetDTO convertirComentarioaGetDTO(Comentario comentario) throws Exception {



        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getFechaCreacion(),
                comentario.getMensaje(),
                comentario.getProductoComentario(),
                comentario.getUsuarioComentario() );

        return  comentarioGetDTO;
    }

    @Override
    public int eliminiarComentario(int codigoComentario) throws Exception {

        validarExiste(codigoComentario);
        comentarioRepo.deleteById(codigoComentario);
        return codigoComentario;

    }

    private void validarExiste(int codigoComentario) throws Exception {

        boolean existe = comentarioRepo.existsById(codigoComentario);

        if( !existe ){
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún usuario");
        }
    }

    @Override
    public ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception {
        return convertirGetDTOaComentario( obtener(codigoComentario) );
    }

    private ComentarioGetDTO convertirGetDTOaComentario(Comentario comentario) {
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getFechaCreacion(),
                comentario.getMensaje(),
                comentario.getProductoComentario(),
                comentario.getUsuarioComentario()
        );
        return comentarioGetDTO;
    }

    @Override
    public Comentario obtener(int codigoComentario) throws Exception {
        Optional<Comentario> comentario = comentarioRepo.findById(codigoComentario);

        if(comentario.isEmpty() ){
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún comentario");
        }

        return comentario.get();
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) {
        return null;
    }
}
