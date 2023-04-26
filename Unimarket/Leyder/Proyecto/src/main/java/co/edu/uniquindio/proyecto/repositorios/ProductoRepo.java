package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    //@Query("select p from Producto p where p.codigo = :codigo")
    //Producto buscarProducto (String codigo);
    @Query("select p from Producto p where p.usuario.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) ")
    List<Producto> listarProductosUsuario(String nombre);



    @Query("select p from Producto p join p.categoriaList c where c = :categoria")
    List<Producto> listarProductosCategoria(Categoria categoria);

    @Query("select p from Producto p where p.precio < :precioMaximo  and p.precio > :precioMinimo")
    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);

    @Query("select f from Usuario u join u.productoListFavorito f where f.usuario.codigo = :codigoUsuario")
    List<Producto> listarProductoFavoritos(int codigoUsuario);
    @Query("select p from Producto p ")
    List<Producto> listarProductos();

   /* @Query("select p from Producto p where p.usuario.productoListFavorito = :codigoUsuario")
    List<Producto> listarProductosFavoritos(int codigoUsuario);*/

    /**
     * @Query("select u from Usuario u where u.email = :correo")
     *     Usuario buscarUsuario (String correo);
     *
     *        @Query("select p from Producto p where p.precio LIKE ")
     *     List<Producto> listarProductosCategoria(Categoria categoria);
     */
    // List<Producto> listarProductosFavoritos(int codigoUsuario);

    @Query("select p from Producto p where p.activo = :estado")
    List<Producto> listarProductosEstado(String estado);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) ")
    List<Producto> obtenerProductoNombre(String nombre);
}
