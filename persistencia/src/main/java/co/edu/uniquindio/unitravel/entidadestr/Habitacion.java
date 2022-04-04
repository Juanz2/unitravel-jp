package co.edu.uniquindio.unitravel.entidadestr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
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
    @ManyToMany(mappedBy = "habitaciones")
    private List<Reserva> reservas;
    @ManyToMany(mappedBy = "habitaciones")
    private List<Cama> camas;
    @OneToMany(mappedBy = "habitacion")
    private List<Foto> fotos;
    @ManyToMany(mappedBy = "habitaciones")
    private List<Caracteristica> caracteristicas;
}
