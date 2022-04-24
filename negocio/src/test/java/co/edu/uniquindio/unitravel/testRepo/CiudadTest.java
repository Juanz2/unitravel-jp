package co.edu.uniquindio.unitravel.testRepo;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void crearCiudad() {
        Ciudad ciudad = new Ciudad("Cali");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);
        Assertions.assertNotNull(ciudadGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstadoCiudad(){

        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);
        ciudad.setEstado("I");
        ciudadRepo.save(ciudad);
        Assertions.assertEquals("I", ciudad.getEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    /**
     *
     */
    public void listarCiudades(){
        List<Ciudad> ciudades = ciudadRepo.findAll();
        ciudades.forEach(System.out::println);
    }
}
