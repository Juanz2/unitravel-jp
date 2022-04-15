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
@AllArgsConstructor
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

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

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

    /**
     * Método constructor de la clase
     * @param precio
     * @param capacidad
     * @param estado
     * @param hotel
     */
    public Habitacion(Double precio, Integer capacidad, String estado, Hotel hotel) {
        this.precio = precio;
        this.capacidad = capacidad;
        this.estado = estado;
        this.hotel = hotel;
    }
}
