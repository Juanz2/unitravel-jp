package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {

    @ToString.Include
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    @ManyToOne
    private NivelAcceso nivelAcceso;

    @ManyToOne
    private Ciudad ciudad;

    public Usuario(String codigo, String nombre, @Email String correo, String password) {
        super(codigo, nombre, correo, password);
    }
}
