package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Caracteristica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @ManyToMany(mappedBy = "caracteristicas")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToMany(mappedBy = "caracteristicas")
    @ToString.Exclude
    private List<Hotel> hoteles;

    /**
     * Método constructor de la clase
     * @param nombre
     * @param estado
     */
    public Caracteristica(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
}
