package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class CiudadServicioTest {

    @Autowired
    private CiudadServicio ciudadServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCiudad(){

        Ciudad ciudad = new Ciudad("Cali", "A");
        try {
            ciudadServicio.registrarCiudad(ciudad);
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCiudad(){

        try {
            Ciudad ciudad = ciudadServicio.obtenerCiudad(1);
            ciudad.setNombre("Bogota");
            ciudadServicio.actualizarCiudad(ciudad);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudad(){

        try {
            ciudadServicio.eliminarCiudad(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());

        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudades(){
        List<Ciudad> listaCiudades = ciudadServicio.listarCiudades();
        listaCiudades.forEach(System.out::println);
    }
}
