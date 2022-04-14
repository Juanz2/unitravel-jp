package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Min(0)
    @Column(nullable = false)
    private Double precio;

    @Min(0)
    @Column(nullable = false)
    private Integer capacidad;

    @ToString.Exclude
    @ManyToMany(mappedBy = "habitaciones")
    private List<Reserva> reservas;

    @ToString.Exclude
    @ManyToMany(mappedBy = "habitaciones")
    private List<Cama> camas;

    @ToString.Exclude
    @ManyToMany(mappedBy = "habitaciones")
    private List<Foto> fotos;

    @ToString.Exclude
    @ManyToMany(mappedBy = "habitaciones")
    private List<Caracteristica> caracteristicas;

    @ToString.Exclude
    @ManyToOne
    private Hotel hotel;
}
