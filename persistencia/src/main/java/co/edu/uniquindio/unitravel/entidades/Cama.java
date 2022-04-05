package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Cama implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false, length = 50)
    private String tipo;

    @ManyToMany
    private List<Habitacion> habitaciones;

    public Cama(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
