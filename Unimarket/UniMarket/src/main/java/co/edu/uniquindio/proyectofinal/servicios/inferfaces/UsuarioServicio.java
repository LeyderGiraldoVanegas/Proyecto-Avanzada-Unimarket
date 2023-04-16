package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.UsuarioDTO;
import co.edu.uniquindio.proyectofinal.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;

public interface UsuarioServicio {

    /**
     * Metodo obtener crear Usuario
     * @param usuarioDTO
     * @return
     * @throws Exception
     */
    int crearUsuario(UsuarioDTO usuarioDTO)  throws Exception;

    /**
     * Metodo obtener actualizar Usuario
     * @param codigoUsuario
     * @param usuarioDTO
     * @return
     * @throws Exception
     */
    UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    /**
     * Metodo obtener eliminiar Usuario
     * @param codigoUsuario
     * @return
     * @throws Exception
     */
    int eliminiarUsuario(int codigoUsuario) throws Exception;

    /**
     * Metodo obtener  UsuarioGetDTO obtenerUsuario
     *
     * @param codigoUsuario
     * @return
     * @throws Exception
     */
    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;

    Usuario obtener(int codigoVendedor) throws Exception;

    Usuario obtenerCupon(int codigoCupon)throws Exception;

    Usuario obtenerCompra(int codigoCompra)throws Exception;

    //Usuario obtenerUsuarioComentario(int codigoUsuarioComentario);

    Usuario obtenerComentario(int codigoUsuario)throws Exception;
}
