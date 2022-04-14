package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Vuelo> vuelosOrigen;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudadDestino")
    private List<Vuelo> vuelosDestino;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Hotel>hoteles;
}
