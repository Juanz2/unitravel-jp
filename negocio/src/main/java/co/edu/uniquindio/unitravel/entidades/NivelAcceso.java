package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class NivelAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "nivelAcceso")
    private List<Usuario> usuarios;

    @Column(nullable = false, length = 1)
    private String estado;

}
