package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Column(nullable = false)
    private LocalDateTime fechaFin;
    @Min(0)
    @Column(nullable = false)
    private Double precioTotal;

    @Column(nullable = false)
    private String estadoReserva;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @Min(0)
    @Column(nullable = false)
    private Integer cantidadPersonas;

    @ManyToMany
    private List<Silla> sillas;
    @ManyToMany
    private List<Habitacion> habitaciones;
    @ManyToOne
    private Usuario usuario;

    /**
     * Método comnstructor de la clase
     * @param fechaReserva
     * @param fechaInicio
     * @param precioTotal
     * @param estadoReserva
     * @param estado
     * @param cantidadPersonas
     * @param usuario
     */
    public Reserva(LocalDateTime fechaReserva, LocalDateTime fechaInicio, Double precioTotal, String estadoReserva, String estado, Integer cantidadPersonas, Usuario usuario) {
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.precioTotal = precioTotal;
        this.estadoReserva = estadoReserva;
        this.estado = estado;
        this.cantidadPersonas = cantidadPersonas;
        this.usuario = usuario;
    }
}
