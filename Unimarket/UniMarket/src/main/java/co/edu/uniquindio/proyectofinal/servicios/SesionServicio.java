package co.edu.uniquindio.proyectofinal.servicios;

import co.edu.uniquindio.proyectofinal.dto.SesionDTO;
import co.edu.uniquindio.proyectofinal.dto.TokenDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public interface SesionServicio {
    TokenDTO login(SesionDTO sesionDTO);


    void logout(int codigoUsuario);
}
