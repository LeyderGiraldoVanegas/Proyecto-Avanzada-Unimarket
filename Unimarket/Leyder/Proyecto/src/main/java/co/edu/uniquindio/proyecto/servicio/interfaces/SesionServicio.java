package co.edu.uniquindio.proyecto.servicio.implementacion;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;

public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO);

    void logout(int codigoUsuario);
}
