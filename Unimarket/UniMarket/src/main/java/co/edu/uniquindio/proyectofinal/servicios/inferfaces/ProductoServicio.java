package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.ProductoDTO;
import co.edu.uniquindio.proyectofinal.dto.ProductoGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Categoria;
import co.edu.uniquindio.proyectofinal.modelo.Estado;
import co.edu.uniquindio.proyectofinal.modelo.Producto;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;

    int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

    int actualizarEstado(int codigoProducto, Estado estado) throws Exception;

    int eliminarProducto(int codigoProducto) throws Exception;

    int eliminarUnidades(int codigoUnidades) throws Exception;

    int eliminarEstado(int codigoEstado)throws Exception;

    Producto obtenerProducto(int codigoProducto) throws Exception;


    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(Estado estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) throws Exception;

    List<ProductoGetDTO> listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

}
