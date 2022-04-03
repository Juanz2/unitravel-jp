package co.edu.uniquindio.unitravel.entidadestr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Hotel {

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

}
