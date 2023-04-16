package co.edu.uniquindio.proyectofinal.dto;

import co.edu.uniquindio.proyectofinal.modelo.Compra;
import co.edu.uniquindio.proyectofinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class CuponGetDTO {

    private Integer codigoCupon;

    private double porcentaje;
    /**
     * ! Esto se tiene que cambiar¡
     */
    private LocalDate fechaLimite;

    private Usuario usuarioCuponDTO;

    private Compra compraCuponDTO;
}
