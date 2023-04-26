package co.edu.uniquindio.proyecto.servicio.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicio.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicio.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;
    private final DetalleCompraRepo detalleCompraRepo;
    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {

       Compra compra = convertirCompraDTOaCompra(compraDTO);

        return compraRepo.save(compra).getCodigo();
    }

    @Override
    public CompraGetDTO actualizarCompra(int codigoCompra, CompraDTO compraDTO) throws Exception {
        validarExiste(codigoCompra);

       Compra compra = convertirCompraDTOaCompra(compraDTO);
       compra.setCodigo(codigoCompra);

       return convertir( compraRepo.save(compra) );

    }

    private Compra convertirCompraDTOaCompra(CompraDTO compraDTO) throws Exception {

        LocalDateTime fecha = LocalDateTime.now();
        Usuario usuario = usuarioServicio.obtener(compraDTO.getUsuarioCompra());
        Compra compra = new Compra();
        //fecaha_creacion
        compra.setFecahaCreacion(fecha);
        //medio_pago
        compra.setMedioPago(compraDTO.getMetodoPago());
        //valor_total
        compra.setValorTotal(compraDTO.getValorTotal());
        //usuario_compra_codigo
        compra.setUsuarioCompra(usuario);
        //List Detalle compra
        compra.setDetalleCompraList(compraDTO.getDetalleCompraList());
       // List<DetalleCompra> detalleCompraList = compra.getDetalleCompraList();
        List<DetalleCompra> lista = compra.getDetalleCompraList();
        for (DetalleCompra d: compra.getDetalleCompraList()){
           // compraRepo.save(compra).getCodigo();
           //int valor = d.getUnidades() * compraDTO.g
            lista.add(d);
            compra.setCuponList(compraDTO.getCuponList());
            detalleCompraRepo.save(d);
        }


        //List Cupones

        return compra;
    }

    private CompraGetDTO convertir(Compra compra) throws Exception {

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
    public List<CompraGetDTO> listarCompras() throws Exception {

        List<Compra> lista = compraRepo.listarCompras();
        List<CompraGetDTO> respuesta = new ArrayList<>();

        for (Compra c : lista ) {
            respuesta.add(convertir(c));
        }
        return respuesta;
    }


}
