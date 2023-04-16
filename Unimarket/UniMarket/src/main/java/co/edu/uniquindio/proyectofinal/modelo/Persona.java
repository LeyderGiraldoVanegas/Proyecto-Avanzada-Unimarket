package co.edu.uniquindio.proyectofinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


// MappedSuperclass = se utiliza para indicar que una clase es una superclase
// que no debe ser mapeada directamente a una tabla de base de
// datos, pero que sus atributos deben ser heredados por las
// subclases que sí serán mapeadas.
//
// Getter and Setter = Obtener y enviar a todos
// los atributos que tenemos declarados en nuestra clase
//
// Equals And Hash Code = Nos ayuda a la hora de comparar objetos
// los compara en la tabla Hash
/**
 * Clase padre Persona va a extender de usuario y moderador.
 * Tiene como Argumentos: código, nombre, email, password.
 */
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
    /**
     * Id = Es el identificador de la clase
     * Column length = limita el tamaño del atributo
     * Equals And Hash Code = A la hora de comparar el objeto lo compara en el HashCode
     */
    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private Integer codigo;

    /**
     * Column Nullable = Validamos que el nombre sea
     * diferente de null
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Column Nullable = Validamos que el email sea
     * diferente de null
     */
    @Column(nullable = false)
    private String email;

    /**
     * Column Nullable = Validamos que el la contraseña sea diferente de null
     */
    @Column(nullable = false)
    private String password;
}
