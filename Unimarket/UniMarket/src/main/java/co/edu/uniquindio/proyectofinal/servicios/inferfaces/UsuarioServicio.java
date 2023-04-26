package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.UsuarioDTO;
import co.edu.uniquindio.proyectofinal.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;

import java.time.LocalDate;

public interface UsuarioServicio {


    int crearUsuario(UsuarioDTO usuarioDTO)  throws Exception;

    UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminiarUsuario(int codigoUsuario) throws Exception;

    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;

    Usuario obtener(int codigoUsuario) throws Exception;

}

