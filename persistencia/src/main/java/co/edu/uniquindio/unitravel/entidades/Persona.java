package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;
    @Column(length = 200, nullable = false)
    private String nombre;
    @Column(length = 200, nullable = false, unique = true)
    private String email;
    @ElementCollection
    private Map<String,String> telefono;

    /**
     * Método constructorr de la clase
     * @param cedula
     * @param nombre
     * @param email
     */
    public Persona(String cedula, String nombre, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
    }
}
