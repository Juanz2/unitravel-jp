package co.edu.uniquindio.unitravel.entidadestr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false)
    private LocalDateTime fechaReserva;
    @Column(nullable = false)
    private LocalDateTime fechaInicio;
    @Min(0)
    @Column(nullable = false)
    private Double precioTotal;
    @Column(nullable = false)
    private String estado;
    @Min(0)
    @Column(nullable = false)
    private Integer cantidadPersonas;


}
