package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

public class Vuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 20, nullable = false)
    private String estadoVuelo;

    @Column(length = 30, nullable = false)
    private String aerolinea;

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @OneToMany(mappedBy = "vuelo")
    private List<Silla> sillas;

    /**
     * Metodo constructor de la clase
     *
     * @param estadoVuelo
     * @param aerolinea
     * @param ciudadOrigen
     * @param ciudadDestino
     */
    public Vuelo(String estadoVuelo, String aerolinea, Ciudad ciudadOrigen, Ciudad ciudadDestino, String estado) {
        this.estadoVuelo = estadoVuelo;
        this.aerolinea = aerolinea;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.estado = estado;
    }
}
