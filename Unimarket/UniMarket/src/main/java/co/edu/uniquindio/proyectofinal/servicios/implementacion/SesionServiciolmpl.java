package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.SesionDTO;
import co.edu.uniquindio.proyectofinal.dto.TokenDTO;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SesionServiciolmpl implements SesionServicio {
    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        return null;
    }

    @Override
    public void logout(int codigoUsuario) {

    }
}
