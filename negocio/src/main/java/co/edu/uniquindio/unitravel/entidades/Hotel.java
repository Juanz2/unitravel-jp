package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 15, nullable = false, unique = true)
    private String nit;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Min(0)
    @Column(nullable = false)
    private Integer numeroEstrellas;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> fotos;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica>caracteristicas;

    @Lob
    private String descripcion;

    @ManyToOne
    private Ciudad ciudad;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

    /**
     * Método constructor de la clase
     * @param nombre
     * @param direccion
     * @param telefono
     * @param numeroEstrellas
     * @param ciudad
     * @param estado
     */
    public Hotel(String nombre, String nit, String direccion, String telefono, Integer numeroEstrellas, Ciudad ciudad, String estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numeroEstrellas = numeroEstrellas;
        this.ciudad = ciudad;
        this.estado = estado;
        this.nit = nit;
    }

    /**
     * Obtiene la primera imagen del hotel
     * @return
     */
    public String getImagenPrincipal(){
        if(fotos != null){
            if(!fotos.isEmpty()){
                return fotos.get(0);
            }
        }
        return "defaultHotel.jpeg";
    }
}
