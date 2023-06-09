package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.UsuarioDTO;
import co.edu.uniquindio.proyectofinal.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;
import co.edu.uniquindio.proyectofinal.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception{

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if(buscado!=null){
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya está en uso");
        }

        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save( usuario ).getCodigo();
    }

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

    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception{
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception{
        return convertir( obtener(codigoUsuario) );
    }

    public Usuario obtener(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    private void validarExiste(int codigoUsuario) throws Exception{
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }

    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }

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
