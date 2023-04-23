import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.servicio.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicio.interfaces.UsuarioServicio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductoTest {
/**

//  @Autowired
    private ProductoServicio productoServicio;

   //@Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrarProducto()throws Exception{

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                123,
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                343);

        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(Categoria.TECNOLOGIA);
        //Se crea la colección de imágenes para el producto.
        List<String> imagenes = new ArrayList<String>();
        imagenes.add("http://www.google.com/images/imagenasus.png");
        imagenes.add("http://www.google.com/images/imagenasus_original.png");

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                1,
                7000000,
                codigoVendedor,
                imagenes,
                categoriaList
        );

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto( productoDTO );

        //Se espera que el servicio retorne el código del nuevo producto
        Assertions.assertNotEquals(0, codigoProducto);
    }*/
}
