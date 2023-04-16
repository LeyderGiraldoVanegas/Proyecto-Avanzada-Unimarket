package co.edu.uniquindio.proyectofinal.repositorios;

import co.edu.uniquindio.proyectofinal.modelo.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepo  extends JpaRepository<Comentario,Integer> {
    //@Query()
    //List<Comentario> obtenerComentarios(int codigoProducto);

    //@Query()
    //List<Comentario>listarComentarios(int codigoUsuario);
}
