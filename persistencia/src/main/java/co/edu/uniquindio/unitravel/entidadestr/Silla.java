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
@EqualsAndHashCode
@NoArgsConstructor
public class Silla implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(length = 20, nullable = false)
    private String posicion;
    @Min(0)
    @Column(nullable = false)
    private Double precio;
    @ManyToOne
    private Vuelo vuelo;
    @ManyToMany(mappedBy = "sillas")
    private List<Reserva>reservas;

}
