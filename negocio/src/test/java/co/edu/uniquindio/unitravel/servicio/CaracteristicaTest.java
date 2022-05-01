package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.servicios.CaracteristicaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

public class CaracteristicaTest {

    @Autowired
    private CaracteristicaServicio caracteristicaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCaracteristica() {
        try {
            Caracteristica caracteristica = new Caracteristica("Eventos", "A");
            caracteristicaServicio.registrarCaracteristica(caracteristica);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.assertTrue(false);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCaracteristica() {
        try {
            Caracteristica caracteristica = caracteristicaServicio.obtenerCaracteristica(1);
            caracteristica.setNombre("Espacios de esparcimineto");
            caracteristica.setEstado("R");
            caracteristicaServicio.actualizarCaracteristica(caracteristica);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCaracteristica(){

        try {
            caracteristicaServicio.eliminarCaracteristica(1);
        }catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentarios(){
        List<Caracteristica> listarComentarios = caracteristicaServicio.obtenerCaracteristicas();
        listarComentarios.forEach(System.out::println);
    }
}
