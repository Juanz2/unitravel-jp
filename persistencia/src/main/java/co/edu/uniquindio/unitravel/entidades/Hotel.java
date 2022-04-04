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
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false, length = 10)
    private String telefono;
    @Min(0)
    @Column(nullable = false)
    private Integer numeroEstrellas;

    @OneToMany(mappedBy = "hotel")
    private List<Foto> fotos;
    @ManyToMany(mappedBy = "hoteles")
    private List<Caracteristica>caracteristicas;
    @ManyToOne
    private Ciudad ciudad;
    @ManyToMany(mappedBy = "hoteles")
    private List<Comentario> comentarios;
}
