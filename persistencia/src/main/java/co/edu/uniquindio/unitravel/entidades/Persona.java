package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@ToString
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
