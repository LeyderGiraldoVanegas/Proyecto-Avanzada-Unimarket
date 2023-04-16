package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.SesionDTO;
import co.edu.uniquindio.proyectofinal.dto.TokenDTO;

public interface SesionServicio {

    void logout(int codigoUsuario);

    TokenDTO login(SesionDTO sesionDTO);
}
