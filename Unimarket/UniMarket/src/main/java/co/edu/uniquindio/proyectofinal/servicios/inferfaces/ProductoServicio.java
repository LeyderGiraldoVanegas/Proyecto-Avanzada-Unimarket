package co.edu.uniquindio.proyectofinal.servicios.inferfaces;

import co.edu.uniquindio.proyectofinal.dto.ProductoDTO;
import co.edu.uniquindio.proyectofinal.dto.ProductoGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Categoria;
import co.edu.uniquindio.proyectofinal.modelo.Estado;
import co.edu.uniquindio.proyectofinal.modelo.Producto;
import java.util.List;

public interface ProductoServicio {

   int  craerProducto(ProductoDTO productoDTO) throws  Exception;
   int  actualizarProducto(int codigoProducto, ProductoDTO productoDTO)throws Exception;

   int actualizarUnidades(int codigoProducto, int unidades)throws Exception;

   int actualizarEstado(int codigoProducto, Estado estado)throws Exception;

   int eliminarProducto(int codigoProducto)throws Exception;
   Producto obtenerProducto (int codigoProducto)throws Exception;

   // ProductoGetDTO eliminarProducto(int codigoProducto);

   //List<ProductoGetDTO> listaProductosUsuario(int codigoUsuario);
   //List<ProductoGetDTO> listaProductosCategoria(Categoria categoria);
//   List<ProductoGetDTO> listaProductosPorEstado(Estado estado);
//
//   List<ProductoGetDTO> listarProductoFavoritos(int codigoUsuario);
//
//   List<ProductoGetDTO>  listarProductoNombre(String nombre);
//   List<ProductoGetDTO> listarProductoPrecio(float precioMinimo, float precioMaximo);
}
