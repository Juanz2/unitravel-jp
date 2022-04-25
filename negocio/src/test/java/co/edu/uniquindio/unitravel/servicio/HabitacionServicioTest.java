package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HabitacionServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class HabitacionServicioTest {

    @Autowired
    private HabitacionServicio habitacionServicio;
    @Autowired
    private HotelServicio hotelServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarHabitacion() {
        try {
            Hotel hotel = hotelServicio.obtenerHotel(1);
            Habitacion habitacion = new Habitacion(150000.0, 2, "A", hotel);
            habitacionServicio.registrarHabitacion(habitacion);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHabitacion() {

        try {
            Habitacion habitacion = habitacionServicio.obtenerHabitacion(1);
            habitacion.setCapacidad(2);
            habitacion.setPrecio(250000.0);
            habitacionServicio.actualizarHabitacion(habitacion);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHabitacion() {
        try {
            habitacionServicio.eliminarHabitacion(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHabitacion(){
        List<Habitacion> listaHabitaciones = habitacionServicio.obtenerHabitaciones();
        listaHabitaciones.forEach(System.out::println);
    }

}
