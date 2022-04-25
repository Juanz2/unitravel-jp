package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Comentario implements Serializable {

    public Comentario(String comentario,int calificacion, String estado, Hotel hotel, Usuario usuario) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.estado = estado;
        this.hotel = hotel;
        this.usuario = usuario;
        this.fechaCalificacion = LocalDateTime.now();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private int calificacion;

    @Column(nullable = false)
    private LocalDateTime fechaCalificacion;

    @Column(length = 1, nullable = false, columnDefinition = "varchar(1) default 'A'")
    private String estado;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Usuario usuario;


}
