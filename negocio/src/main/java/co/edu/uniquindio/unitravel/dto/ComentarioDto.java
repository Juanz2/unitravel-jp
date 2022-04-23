package co.edu.uniquindio.unitravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ComentarioDto {

    private String nombreUsuario;
    private String nombreHotel;
    private LocalDateTime fechaComentario;
    private  int calificacion;
    private String comentario;
}
