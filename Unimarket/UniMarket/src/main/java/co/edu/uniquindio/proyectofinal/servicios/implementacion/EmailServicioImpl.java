package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.EmailDTO;

import co.edu.uniquindio.proyectofinal.servicios.inferfaces.EmailServicio;
import org.springframework.stereotype.Service;

@Service
public class EmailServicioImpl implements EmailServicio {
    @Override
    public String enviarEmail(EmailDTO emailDTO) {
        return null;
    }
}
