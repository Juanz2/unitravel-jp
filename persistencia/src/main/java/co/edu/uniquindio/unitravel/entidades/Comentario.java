package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private String calificacion;

    @Column(nullable = false)
    private LocalDateTime fechaCalificacion;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @ManyToMany
    private List<Hotel> hoteles;

    @ManyToOne
    private Usuario usuario;
}
