package co.edu.uniquindio.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UsuarioDTO {
    private String nombre;
    private String email;
    private String password;
    private String direccion;
    private String telefono;

}
