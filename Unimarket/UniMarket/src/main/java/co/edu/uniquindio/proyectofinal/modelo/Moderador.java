package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
// EqualsAndHashCode = Se utilizan para comparar objetos y
// almacenarlos en estructuras de datos hash
@Entity
@Setter
@Getter
@NoArgsConstructor
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Moderador extends  Persona{

    @OneToMany(mappedBy = "moderador")
    private List<Producto> productoList;
}
