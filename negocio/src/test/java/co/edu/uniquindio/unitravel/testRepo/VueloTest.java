package co.edu.uniquindio.unitravel.testRepo;

import co.edu.uniquindio.unitravel.dto.VueloDto;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloTest {

    @Autowired
    private VueloRepo vueloRepo;


    @Test
    public void crearVuelo(){

        Ciudad ciudadOrigen = new Ciudad("Cali");
        Ciudad ciudadDestino = new Ciudad("Bogotá");
        Vuelo vuelo = new Vuelo("Pendiente", "Avianca", ciudadOrigen, ciudadDestino, "A");
        Vuelo vueloCreado = vueloRepo.save(vuelo);
        Assertions.assertNotNull(vueloCreado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void modificarEstadoVuelo(){

        Vuelo vueloModificar = vueloRepo.findById(1).orElse(null);
        if (vueloModificar != null) {
            vueloModificar.setEstadoVuelo("Atrasado");
            vueloRepo.save(vueloModificar);
            Assertions.assertEquals("Atrasado", vueloModificar.getEstadoVuelo());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void contarVuelosPorCiudad(){
        List<VueloDto> listaVuelosPorCiudad = vueloRepo.vuelosPorCiudad();
        listaVuelosPorCiudad.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void vuelosAerolinea(){
        List<Vuelo> listaVuelos = vueloRepo.vuelosAerolinea("Avianca");
        listaVuelos.forEach(System.out::println);
        Assertions.assertEquals(1, listaVuelos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void vuelosPorHotel(){
        List<Vuelo> listaVuelos = vueloRepo.vuelosPorHotel(1);
        listaVuelos.forEach(System.out::println);
    }


}
