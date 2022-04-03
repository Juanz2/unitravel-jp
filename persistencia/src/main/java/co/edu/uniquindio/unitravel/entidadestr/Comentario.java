package co.edu.uniquindio.unitravel.entidadestr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Comentario {

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

}
