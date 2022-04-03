package co.edu.uniquindio.unitravel.entidadestr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;
    @Column(nullable = false, length = 200)
    private String nombre;
    @Email
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 200)
    private String password;

}
