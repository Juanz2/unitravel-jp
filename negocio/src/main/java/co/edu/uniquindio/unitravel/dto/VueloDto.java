package co.edu.uniquindio.unitravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VueloDto {

    private String ciudadOrigen;
    private String ciudadDestino;
    private int codigoVuelo;
    private String estadoVuelo;
    private long numeroRegistros;

    public VueloDto(String ciudadOrigen, String ciudadDestino, int codigoVuelo, String estadoVuelo, long numeroRegistros) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.codigoVuelo = codigoVuelo;
        this.estadoVuelo = estadoVuelo;
        this.numeroRegistros = numeroRegistros;
    }
}
