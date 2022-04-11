package co.edu.uniquindio.unitravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VueloDto {

    private String ciudadOrigen;
    private int codigoVuelo;
    private String estadoVuelo;
    private String ciudadDestino;
    private int numeroRegistros;
}
