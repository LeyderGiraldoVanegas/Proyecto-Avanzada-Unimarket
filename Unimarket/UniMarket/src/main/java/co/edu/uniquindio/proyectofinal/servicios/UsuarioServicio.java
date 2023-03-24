package co.edu.uniquindio.proyectofinal.servicios;

import co.edu.uniquindio.proyectofinal.dto.UsuarioDTO;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;

public interface UsuarioServicio {

    int creaUsuario(UsuarioDTO usuarioDTO);
    int actualizarUsurio (int codigoUsuario, UsuarioDTO usuarioDTO);

    int eliminarUsuario (int codigoUsuario);

    UsuarioDTO obtenerUsuario (int codigoUsuario);
}
