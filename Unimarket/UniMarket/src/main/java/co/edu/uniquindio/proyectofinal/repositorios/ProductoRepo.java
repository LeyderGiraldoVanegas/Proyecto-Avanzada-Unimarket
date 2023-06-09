package co.edu.uniquindio.proyectofinal.repositorios;

import co.edu.uniquindio.proyectofinal.modelo.Producto;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    @Query("select p from Producto p where p.vendedor.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.activo = 1")
    List<Producto> listarProductosNombre(String nombre);
}
