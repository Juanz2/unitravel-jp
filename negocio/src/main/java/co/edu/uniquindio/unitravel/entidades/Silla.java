package co.edu.uniquindio.unitravel.entidades;

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

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @Column(length = 10, nullable = false, columnDefinition = "varchar(10) default 'Disponible'")
    private String estadoSilla;

    @ManyToMany(mappedBy = "sillas")
    private List<Reserva>reservas;

    /**
     * Método constructor de la clase
     * @param posicion
     * @param estado
     */
    public Silla(String posicion, String estado) {
        this.posicion = posicion;
        this.precio = precio;
        this.vuelo = vuelo;
        this.estado = estado;
        this.estadoSilla = estadoSilla;
    }
}
