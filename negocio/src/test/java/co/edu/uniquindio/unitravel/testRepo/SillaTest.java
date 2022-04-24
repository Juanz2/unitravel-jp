package co.edu.uniquindio.unitravel.testRepo;

import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.SillaRepo;
import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.lang.reflect.Array;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SillaTest {

    @Autowired
    private SillaRepo sillaRepo;
    @Autowired
    private VueloRepo vueloRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearSilla() {

        Vuelo vuelo = vueloRepo.findById(1).orElse(null);
        if (vuelo != null) {
            Silla silla = new Silla("D1", 25000.00, vuelo, "A", "Disponible");
            Silla sillaGuardada = sillaRepo.save(silla);
            Assertions.assertNotNull(sillaGuardada);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstadoSilla() {
        Silla silla = sillaRepo.findById(1).orElse(null);
        if (silla != null) {
            silla.setEstado("I");
            sillaRepo.save(silla);
            Assertions.assertEquals("I", silla.getEstado());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarSillas() {
        List<Silla> listaSillas = sillaRepo.findAll();
        listaSillas.forEach(System.out::println);
        Assertions.assertEquals(18, listaSillas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerSillasDisponiblesVuelo() {
        List<Silla> listaSillas = sillaRepo.obtenerSillasDisponiblesVuelo(1);
        listaSillas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerSillasOrdenPrecio() {
        List<Silla>sillas = sillaRepo.obtenerSillasOrdenPrecio();
        sillas.forEach(System.out::println);
    }

}
