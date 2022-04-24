package co.edu.uniquindio.unitravel.testRepo;


import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HabitacionTest {

    @Autowired
    private HabitacionRepo habitacionRepo;
    @Autowired
    private HotelRepo hotelRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHabitacion() {
        Hotel hotel = hotelRepo.findById(1).orElse(null);
        if (hotel != null) {
            Habitacion habitacion = new Habitacion(25000.00, 2, "A", hotel);
            Habitacion habitacionGuardada = habitacionRepo.save(habitacion);
            Assertions.assertNotNull(habitacionGuardada);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHabitacion() {
        Habitacion habitacion = habitacionRepo.getById(1);
        if (habitacion != null) {
            habitacion.setEstado("I");
            habitacion.setCapacidad(3);
            habitacion.setPrecio(350000.0);
            Habitacion habitacionActualizada = habitacionRepo.save(habitacion);
            Assertions.assertNotNull(habitacionActualizada);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHabitaciones() {
        List<Habitacion> habitaciones = habitacionRepo.findAll();
        habitaciones.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCaracteristicasHabitacion(){
        List<Caracteristica> listaComentarios = habitacionRepo.obtenerCaracteristicasHabitacion(1);
        listaComentarios.forEach(System.out::println);
    }
}
