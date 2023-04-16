package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.Producto;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO {

    private int codigoComentario;
    private String mensaje;

    private LocalDateTime fechaCreacion;

    private Producto productoComentario;
    private  Usuario usuarioComentario;

}
