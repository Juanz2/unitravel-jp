package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import co.edu.uniquindio.unitravel.servicios.VueloServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class VueloTest {

    @Autowired
    private VueloServicio vueloServicio;
    @Autowired
    private CiudadServicio ciudadServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarVuelo(){

        try {
            Ciudad ciudadOrigen = ciudadServicio.obtenerCiudad(1);
            Ciudad ciudadDestino = ciudadServicio.obtenerCiudad(2);
            Vuelo vuelo = new Vuelo("Disponible", "Avianca", ciudadOrigen, ciudadDestino, "A");
            vueloServicio.registrarVuelo(vuelo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
