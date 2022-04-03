package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Prestamo implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    private LocalDateTime fechaPrestamo;
    private LocalDate fechaDevolucion;

    /**
     *
     * @param codigo
     * @param fechaPrestamo
     * @param fechaDevolucion
     */
    public Prestamo(int codigo, LocalDateTime fechaPrestamo, LocalDate fechaDevolucion) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
}
