package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.UsuarioDTO;
import co.edu.uniquindio.proyectofinal.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Comentario;
import co.edu.uniquindio.proyectofinal.modelo.Compra;
import co.edu.uniquindio.proyectofinal.modelo.Cupon;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;
import co.edu.uniquindio.proyectofinal.repositorios.*;

import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    /**
     * Declaración de atributos
     */
    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;

    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;

    private final CuponRepo cuponRepo;

    /**
     *
     * @param usuarioDTO
     * @return
     * @throws Exception
     */
    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception{

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if(buscado!=null){
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya está en uso");
        }

        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save( usuario ).getCodigo();
    }

    /**
     *
     * @param codigoUsuario
     * @param usuarioDTO
     * @return
     * @throws Exception
     */
    @Override
    public UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception{

        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigo(codigoUsuario);

        return convertir( usuarioRepo.save(usuario) );
    }

    /**
     *
     * @param codigoUsuario
     * @return
     * @throws Exception
     */
    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception{
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario
     * @return
     * @throws Exception
     */
    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception{
        return convertir( obtener(codigoUsuario) );
    }

    /**
     *
     * @param codigoUsuario
     * @return
     * @throws Exception
     */
    public Usuario obtener(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    @Override
    public Usuario obtenerCupon(int codigoCupon) throws Exception {

        Optional<Cupon> cupon = cuponRepo.findById(codigoCupon);

        if (cupon.isEmpty()){
            throw new Exception("El código "+codigoCupon+" no está asociado a ningún cupon");
        }

        return cupon.get().getUsuarioCupon();
    }

    @Override
    public Usuario obtenerCompra(int codigoCompra) throws Exception {
        Optional<Compra> compra= compraRepo.findById(codigoCompra);

        if (compra.isEmpty()){
            throw new Exception("El código "+codigoCompra+" no está asociado a ningún compra");
        }
        return compra.get().getUsuarioCompra();
    }


    @Override
    public Usuario obtenerComentario(int codigoComentario) throws Exception {
        Optional<Comentario> comentario = comentarioRepo.findById(codigoComentario);

        if (comentario.isEmpty()){
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún comentario");
        }

        return comentario.get().getUsuarioComentario();
    }


    /**
     *
     * @param codigoUsuario
     * @throws Exception
     */
    private void validarExiste(int codigoUsuario) throws Exception{
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }

    /**
     *
     * @param usuario
     * @return
     */
    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }

    /**
     *
     * @param usuarioDTO
     * @return
     */
    private Usuario convertir(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setPassword( usuarioDTO.getPassword() );

        return usuario;
    }

}
