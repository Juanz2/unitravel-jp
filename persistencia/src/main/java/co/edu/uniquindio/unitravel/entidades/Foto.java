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
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String url;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @ManyToMany
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToMany
    @ToString.Exclude
    private List<Hotel> hoteles;

    /**
     * Método constructor de la clase
     * @param codigo
     * @param url
     * @param estado
     */
    public Foto(int codigo, String url, String estado) {
        this.codigo = codigo;
        this.url = url;
        this.estado = estado;
    }
}
