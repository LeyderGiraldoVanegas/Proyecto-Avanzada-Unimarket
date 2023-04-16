package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.ProductoDTO;
import co.edu.uniquindio.proyectofinal.dto.ProductoGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Categoria;
import co.edu.uniquindio.proyectofinal.modelo.Estado;
import co.edu.uniquindio.proyectofinal.modelo.Producto;
import co.edu.uniquindio.proyectofinal.repositorios.ProductoRepo;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.ProductoServicio;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ) );
        producto.setImagenesList( productoDTO.getImagenList() );
        producto.setCategoriaList( productoDTO.getCategoriaList() );
        producto.setActivo( "INACTIVO" );
        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaLimite( LocalDateTime.now().plusDays(60) );

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception{
        return 0;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception{
        return 0;
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) throws Exception{
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception{
        return 0;
    }

    @Override
    public int eliminarUnidades(int codigoUnidades) throws Exception {
        return 0;
    }

    @Override
    public int eliminarEstado(int codigoEstado) throws Exception {
        return 0;
    }

    @Override
    public Producto obtenerProducto(int codigoProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if (producto.isEmpty()){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
        }

        return producto.get();
    }


    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {

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
                producto.getActivo(),
                producto.getFechaLimite(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getUsuario().getCodigo(),
                producto.getImagenesList(),
                producto.getCategoriaList()
        );

        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) throws Exception {

        //usuarioServicio.validarExite(codigoUsuario);

        //List<Producto> lista = productoRepo.listarProductosFavoritos(codigoUsuario);
        //List<ProductoGetDTO> respuesta = new ArrayList<>();

        //for(Producto p : lista){
          //  respuesta.add( convertir(p) );
        //}
        //return respuesta;
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {

        List<Producto> lista = productoRepo.listarProductosUsuario(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {

        return null;
    }
}
