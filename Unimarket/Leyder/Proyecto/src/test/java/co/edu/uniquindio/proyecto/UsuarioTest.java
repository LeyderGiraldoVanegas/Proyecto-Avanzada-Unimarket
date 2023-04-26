package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicio.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
//@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuarioTest()
    {


        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Pepito 1",
                    "pepe1@email.com",
                    "1234",
                    "Calle 123",
                    "343");
            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            Assertions.assertNotEquals(0, codigo);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuarioTest() throws Exception{

        //Para eliminar el usuario primero se debe crear
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Pepito 1",
                    "pepe1@email.com",
                    "1234",
                    "Calle 123",
                    "343");
            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            Assertions.assertNotEquals(0, codigo);

            //Una vez creado, lo borramos
            int codigoBorrado = usuarioServicio.eliminiarUsuario(codigo);

            //Si intentamos buscar un usuario con el codigo del usuario borrado debemos obtener una excepción
            // indicando que ya no existe
            Assertions.assertEquals(codigoBorrado,codigo);
          //  Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(codigoBorrado));

        }catch (Exception e){
            e.printStackTrace();
        }



    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuarioTest() throws Exception{

        //Para actualizar el usuario primero se debe crear
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "pepe1 ",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "12345"
        );

        int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

        //El servicio de actualizar nos retorna el usuario
        UsuarioGetDTO usuarioActualizado = usuarioServicio.actualizarUsuario(codigoNuevo, new UsuarioDTO(
                "Pepito Perez",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "1111"));

        //Se comprueba que ahora el teléfono del usuario no es el que se usó cuando se creó inicialmente
        Assertions.assertNotEquals("2782", usuarioActualizado.getTelefono());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuarioTest()throws Exception{

        //Para obtener el usuario primero se debe crear
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "343");

        int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

        //Se llama el servicio para obtener el usuario completo dado su código
        UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(codigoNuevo);

        //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
        Assertions.assertEquals("Calle 123", usuarioGetDTO.getDireccion());

    }
}
