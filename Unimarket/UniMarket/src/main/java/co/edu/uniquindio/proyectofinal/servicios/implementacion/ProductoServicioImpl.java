package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.ProductoDTO;
import co.edu.uniquindio.proyectofinal.dto.ProductoGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Activo;
import co.edu.uniquindio.proyectofinal.modelo.Categoria;
import co.edu.uniquindio.proyectofinal.modelo.Estado;
import co.edu.uniquindio.proyectofinal.modelo.Producto;
import co.edu.uniquindio.proyectofinal.repositorios.ProductoRepo;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.ProductoServicio;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int craerProducto(ProductoDTO productoDTO) throws Exception {
        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setCantidad( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ) );
        producto.setArchivo( productoDTO.getImagenes() );
        producto.setCategorias( productoDTO.getCategorias() );
        producto.setEstados( Estado.SIN_REVISAR );
        producto.setFechaCreado( LocalDateTime.now() );
        producto.setFechaLimite(LocalDateTime.now().plusDays(60));

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {
        return 0;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception {
        return 0;
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) throws Exception {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public Producto obtenerProducto(int codigoProducto) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listaProductosUsuario(int codigoUsuario) {
        List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getEstados(),
                producto.getFechaLimite(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCantidad(),
                producto.getPrecio(),
                producto.getUsuario().getCodigo(),
                producto.getArchivo(),
                producto.getCategorias()
        );

        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listaProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listaProductosPorEstado(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductoFavoritos(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductoNombre(String nombre) {
        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductoPrecio(float precioMinimo, float precioMaximo) {
        return null;
    }
}
