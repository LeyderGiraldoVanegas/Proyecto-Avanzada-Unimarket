package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.CompraDTO;
import co.edu.uniquindio.proyectofinal.dto.CompraGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Compra;
import co.edu.uniquindio.proyectofinal.repositorios.CompraRepo;

import co.edu.uniquindio.proyectofinal.servicios.inferfaces.CompraServicio;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;
    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setFecahaCreacion(LocalDateTime.now());
        compra.setValorTotal(compraDTO.getValorTotal());
        compra.setMedioPago("TARGETA");
        compra.setUsuarioCompra( usuarioServicio.obtenerCompra(compraDTO.getCodigoCompra()));
        compra.setDetalleCompraList(compraDTO.getDetalleCompraList());
        compra.setCuponList(compraDTO.getCuponList());
        return compraRepo.save(compra).getCodigo();
    }

    @Override
    public CompraGetDTO actualizarCompra(int codigoCompra, CompraDTO compraDTO) throws Exception {
        validarExiste(codigoCompra);

        Compra compra = convertir(compraDTO);
        compra.setCodigo(codigoCompra);

        return convertir( compraRepo.save(compra) );
    }

    private Compra convertir(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setFecahaCreacion(LocalDateTime.now());
        compra.setValorTotal(compraDTO.getValorTotal());
        compra.setMedioPago("TARGETA");
        compra.setUsuarioCompra( usuarioServicio.obtenerCompra(compraDTO.getCodigoCompra()));
        compra.setDetalleCompraList(compraDTO.getDetalleCompraList());
        compra.setCuponList(compraDTO.getCuponList());
        return compra;
    }

    private CompraGetDTO convertir(Compra compra){

        CompraGetDTO compraGetDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getFecahaCreacion(),
                compra.getValorTotal(),
                compra.getMedioPago(),
                compra.getUsuarioCompra(),
                compra.getDetalleCompraList(),
                compra.getCuponList()
        );

        return compraGetDTO;
    }

    private void validarExiste(int codigoCompra) throws Exception {
        boolean existe = compraRepo.existsById(codigoCompra);

        if( !existe ){
            throw new Exception("El código "+codigoCompra+" no está asociado a ningún compra");
        }
    }

    @Override
    public int eliminiarCompra(int codigoCompra) throws Exception {
        validarExiste(codigoCompra);
        compraRepo.deleteById(codigoCompra);
        return codigoCompra;
    }

    @Override
    public Compra obtenerCompra(int codigoCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);

        if(compra.isEmpty() ){
            throw new Exception("La compra no existe");
        }

        return compra.get();
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }
}

