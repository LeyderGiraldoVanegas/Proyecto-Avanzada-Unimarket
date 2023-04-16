package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.CuponDTO;
import co.edu.uniquindio.proyectofinal.dto.CuponGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Cupon;

public interface CuponServicio {
    int crearCupon(CuponDTO cuponDTO) throws Exception;

    CuponGetDTO actualizarCupon(int codigoCupon, CuponDTO cuponDTO)throws Exception;

    int eliminiarCupon(int codigoCupon)throws Exception;

    CuponGetDTO obtenerCupon(int codigoCupon)throws Exception;

    Cupon obtener(int codigoComentario)throws Exception;
}
