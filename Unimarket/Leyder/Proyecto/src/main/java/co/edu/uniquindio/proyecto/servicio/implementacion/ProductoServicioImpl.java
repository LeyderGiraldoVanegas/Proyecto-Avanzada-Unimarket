package co.edu.uniquindio.proyecto.servicio.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicio.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicio.interfaces.UsuarioServicio;
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

        /**
         * validar usuario
         * validar code producto
         * validar estado producto = siempre comience inactivo
         * validar que las unidades sean mayor a 1
         * validar datos obligatorios
         */

        Usuario codigoVendedor = usuarioServicio.obtener(productoDTO.getCodigoVendedor());


    if (codigoVendedor != null){

        Producto producto = convertirDTOaProducto(productoDTO);

        return productoRepo.save( producto ).getCodigo();
    }else {
        throw new Exception("El Usuario  "+productoDTO.getCodigoVendedor()+" ya está en uso");
    }
    }

    private Producto convertirDTOaProducto(ProductoDTO productoDTO) throws Exception {

        Usuario codigoVendedor = usuarioServicio.obtener(productoDTO.getCodigoVendedor());
         Producto producto = new Producto();
       //  producto.setCodigo(10);
         producto.setNombre( productoDTO.getNombre() );
         producto.setDescripcion( productoDTO.getDescripcion() );
         producto.setUnidades( productoDTO.getUnidades() );
         producto.setPrecio( productoDTO.getPrecio() );
         producto.setUsuario( codigoVendedor );
         producto.setImagenesList( productoDTO.getImagenList() );
         producto.setCategoriaList( productoDTO.getCategoriaList() );
         producto.setActivo( "INACTIVO" );
         producto.setFechaCreacion( LocalDateTime.now() );
         producto.setFechaLimite(LocalDateTime.now());
         //producto.setFechaLimite( LocalDateTime.now().plusDays(60) );
         producto.setModerador(null);

         return  producto;
    }


    @Override
    public ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception{

        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(codigoProducto);

        Producto producto = convertirDTOaProducto(productoDTO);
        producto.setCodigo(codigoProducto);

        return convertir( productoRepo.save(producto) );


    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception {
        return 0;
    }

    private void validarExiste(int codigoProducto) throws Exception {

        boolean existe = productoRepo.existsById(codigoProducto);

        if( !existe ){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún usuario");
        }

    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception{

        validarExiste(codigoProducto);
        productoRepo.deleteById(codigoProducto);
        return codigoProducto;

    }



    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception {

        return convertir( obtener(codigoProducto) );
    }

    @Override
    public Producto obtener(int codigoProducto) throws Exception {

        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if(producto.isEmpty() ){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún usuario");
        }

        return producto.get();
    }

    @Override
    public int addProductoFavorito(int codigoProducto, int codigoVendedor) throws Exception {
        Producto producto = obtener(codigoProducto);
        Usuario usuario = producto.getUsuario();

        List<Usuario> usuarioFavoritoList = producto.getUsuarioFavoritoList();

        if (usuarioFavoritoList == null){
            usuarioFavoritoList = new ArrayList<>();
            usuarioFavoritoList.add(usuario);
            producto.setFavoritosList(usuarioFavoritoList);
        }else {
            usuarioFavoritoList.add(usuario);
            producto.setFavoritosList(usuarioFavoritoList);
        }

        //usuario.setProductoFavoritoList((List<Producto>) producto);
       // producto.setFavoritosList();

        return usuarioFavoritoList.size();
    }

    @Override
    public List<ProductoGetDTO> listarProductos() {
        List<Producto> lista = productoRepo.listarProductos();
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(String estado) {
        List<Producto> lista = productoRepo.listarProductosEstado(estado);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> buscarProductonombre(String nombre) throws Exception {
        List<Producto> lista = productoRepo.obtenerProductoNombre(nombre);
        //Optional<Producto> producto = productoRepo.obtenerProductoNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;

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

    @Override
    public ProductoGetDTO convertir(Producto producto){

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

        List<Producto> lista = productoRepo.listarProductosCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;

    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario)  {

        List<Producto> lista = productoRepo.listarProductoFavoritos(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
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

        List<Producto> lista = productoRepo.listarProductosPrecio(precioMinimo,precioMaximo);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;

    }


}
