import co.edu.uniquindio.proyectofinal.dto.UsuarioDTO;
import co.edu.uniquindio.proyectofinal.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearUsuarioTest(){

        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito 1", "pepe1@email.com", "1234", "Calle 123", "343");
            usuarioServicio.crearUsuario(usuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void eliminarUsuarioTest(){
        try {
            usuarioServicio.eliminiarUsuario(1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void actualizarUsuarioTest(){
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito Perez", "pepe1@email.com", "1234", "Calle 123", "2782");
            usuarioServicio.actualizarUsuario(1, usuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void obtenerUsuarioTest(){
        try {
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(1);
            System.out.println(usuarioGetDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
