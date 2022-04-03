package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String isbn;
    private String nombre;
    private int unidades;
    private short anio;


    /**
     *
     * @param isbn
     * @param nombre
     * @param unidades
     * @param anio
     */
    public Libro(String isbn, String nombre, int unidades, short anio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.unidades = unidades;
        this.anio = anio;
    }
}
