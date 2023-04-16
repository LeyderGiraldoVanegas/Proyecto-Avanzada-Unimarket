package co.edu.uniquindio.proyectofinal.repositorios;

import co.edu.uniquindio.proyectofinal.modelo.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuponRepo extends JpaRepository<Cupon, Integer> {

}
