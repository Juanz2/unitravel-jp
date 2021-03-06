package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    @Column(length = 10)
    private String numeroHabitacion;

    @Min(0)
    @Column(nullable = false)
    private Integer capacidad;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @ToString.Exclude
    @ManyToMany(mappedBy = "habitaciones")
    private List<Reserva> reservas;

    @ManyToMany
    private List<Cama> camas;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> fotos;

    @ToString.Exclude
    @ManyToMany
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
    /**
     * Obtiene la primera imagen del hotel
     * @return
     */
    public String getImagenPrincipal(){
        if(fotos != null){
            if(!fotos.isEmpty()){
                return fotos.get(0);
            }
        }
        return "HabitacionDefault.jpeg";
    }
}
