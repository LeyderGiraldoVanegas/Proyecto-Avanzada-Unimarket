package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.CompraDTO;
import co.edu.uniquindio.proyectofinal.dto.CompraGetDTO;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    @Override
    public int crearCompra(CompraDTO compraDTO) {
        return 0;
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }
}
