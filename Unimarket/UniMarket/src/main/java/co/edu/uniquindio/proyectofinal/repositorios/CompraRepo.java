package co.edu.uniquindio.proyectofinal.repositorios;

import co.edu.uniquindio.proyectofinal.modelo.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {


}
