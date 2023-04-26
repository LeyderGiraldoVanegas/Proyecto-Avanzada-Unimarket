package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.servicio.interfaces.CloudinaryServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
@Transactional
public class CloudinaryTest {
    @Autowired
    private CloudinaryServicio cloudinaryServicio;


    @Test
    public void subirImagenTest() throws Exception {
        // C:\Users\Acer\Downloads
        File file = new File("C:\\Users\\Acer\\Downloads\\prueba.jpg");

        cloudinaryServicio.subirImagen(file,"dto");
    }

    @Test
    public void eliminarImagenTest() throws Exception {
        File file = new File("C:\\Users\\Acer\\Downloads\\prueba.jpg");
        //  cloudinary.uploader().upload(file, ObjectUtils.asMap("Articulos","Articulos"));


    }
}
