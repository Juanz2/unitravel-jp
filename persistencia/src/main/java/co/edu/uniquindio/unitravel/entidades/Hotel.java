package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false, length = 200)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false, length = 10)
    private String telefono;
    @Min(0)
    @Column(nullable = false)
    private Integer numeroEstrellas;

    @ManyToMany(mappedBy = "hoteles")
    @ToString.Exclude
    private List<Foto> fotos;

    @ManyToMany(mappedBy = "hoteles")
    @ToString.Exclude
    private List<Caracteristica>caracteristicas;
    @ManyToOne
    private Ciudad ciudad;
    @ManyToMany(mappedBy = "hoteles")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;
}
