package co.edu.uniquindio.proyecto.servicio.interfaces;

import co.edu.uniquindio.proyecto.dto.EmailDTO;

public interface EmailServicio {
    String enviarEmail(EmailDTO emailDTO);
}
