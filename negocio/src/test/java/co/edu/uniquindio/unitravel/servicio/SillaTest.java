package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.servicios.SillaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class SillaTest {

    private class SillaServicioTest {

        @Autowired
        private SillaServicio sillaServicio;

        @Test
        @Sql("classpath:dataset.sql")
        public void registrarSilla() {

            Silla silla = new Silla("A", "Disponible");
            try {
                sillaServicio.registrarSilla(silla);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Assertions.assertTrue(false);
            }
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void actualizarSilla() {

            try {
                Silla silla = sillaServicio.obtenerSilla(1);
                silla.setPosicion("B");
                silla.setEstadoSilla("Reservada");
                silla.setPrecio(85000.0);
                sillaServicio.actualizarSilla(silla);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void eliminarSilla() {
            try {
                sillaServicio.eliminarSilla(1);
            } catch (Exception e) {
                Assertions.assertTrue(false);
                System.out.println(e.getMessage());
            }

        }
        @Test
        @Sql("classpath:dataset.sql")
        public void listarCiudades(){
            List<Silla> listaSilla = sillaServicio.obtenerSillas();
            listaSilla.forEach(System.out::println);
        }

    }
}
