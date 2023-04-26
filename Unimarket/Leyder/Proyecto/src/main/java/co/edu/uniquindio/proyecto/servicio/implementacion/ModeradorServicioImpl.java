package co.edu.uniquindio.proyecto.servicio.implementacion;


import co.edu.uniquindio.proyecto.modelo.Moderador;

import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.servicio.interfaces.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicio.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio{

    @Autowired
    ModeradorRepo moderadorRepo;
    @Autowired
    private ProductoServicio productoServicio;
    @Override
    public boolean aprobarProducto(int codigoProducto, int codigoModerador) throws Exception {

        Producto producto = productoServicio.obtener(codigoProducto);
        if (producto!= null){
            if (!producto.getActivo().equals("ACTIVO")){
                producto.setActivo("ACTIVO");
                producto.setFechaLimite(LocalDateTime.now().plusDays(60));
                producto.setModerador(obtenerModerador(codigoModerador));
                return true;
            }else {
                throw new Exception("El producto ya esta activo");

            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }
        //return false;
    }

    @Override
    public void rechazarProducto(int codigoProducto) throws Exception {

        Producto producto = productoServicio.obtener(codigoProducto);
        if (producto!= null){
            if (!producto.getActivo().equals("INACTIVO")){
                producto.setActivo("INACTIVO");
            }else {
                throw new Exception("El producto ya esta INACTIVO");
            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }
    }

    @Override
    public Moderador obtenerModerador(int codigoModerador) throws Exception {
        Optional<Moderador> moderador = moderadorRepo.findById(codigoModerador);

        if(moderador.isEmpty() ) {
            throw new Exception("El código " + codigoModerador + " no está asociado a ningún usuario");
        }
            return moderador.get();
    }
}
