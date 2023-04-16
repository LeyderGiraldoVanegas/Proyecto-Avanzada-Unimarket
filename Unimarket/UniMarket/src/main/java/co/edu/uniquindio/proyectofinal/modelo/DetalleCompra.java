package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

// Getter and Setter = Obtener y enviar a todos
// los atributos que tenemos declarados en nuestra clase
//
// NoArgsConstructor = Un constructor sin argumentos generado
// automáticamente por Lombok.
//
// ToString = Se utiliza para generar automáticamente el método toString() de una clase.
//
// Entity = Se usa para indicar que una clase es una entidad que se
// puede mapear a una tabla de base de datos.
//
// EqualsAndHashCode = Se emplear para comparar objetos y
// almacenarlos en estructuras de datos hash
//
// EqualsAndHashCode(onlyExplicitlyIncluded = true) = Permite incluir solo
// los atributos que se marcan explícitamente con la anotación
// @EqualsAndHashCode.Include.

/**
 * Los atributos necesarios para la clase de DetalleCompra son:
 * código, unidades y precioProducto
 */
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class DetalleCompra {
    /**
     * El código es la PK de la clase DetalleCompra
     */
    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    /**
     * Unidades
     */
    @Column(nullable = false)
    private Integer unidades;

    @Column(nullable = false)
    private float precioProducto;


    @ManyToOne
    private Compra compra;

    @ManyToOne
    private Producto productoDetalleCompra;
}

