package co.edu.uniquindio.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailDTO {

    private String asunto;
    private String Cuerpo;
    private String Destinatario;
}
