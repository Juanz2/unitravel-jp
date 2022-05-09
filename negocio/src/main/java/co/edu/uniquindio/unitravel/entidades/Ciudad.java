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
@AllArgsConstructor
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Vuelo> vuelosOrigen;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudadDestino")
    private List<Vuelo> vuelosDestino;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Hotel> hoteles;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;

    public Ciudad(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
}

