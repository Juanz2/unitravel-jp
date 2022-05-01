package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class HotelServicioTest {

    @Autowired
    private HotelServicio hotelServicio;

    @Autowired
    private CiudadServicio ciudadServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarHotel(){

        try {
            Ciudad ciudad = ciudadServicio.obtenerCiudad(1);
            Hotel hotel = new Hotel("Hotel Plaza Cento","900653878-1" ,"Calle 2 # 16-30", "3128792344", 5, ciudad, "A");
            hotelServicio.registrarHotel(hotel);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHotel(){
        try {
            Hotel hotel = hotelServicio.obtenerHotel(1);
            hotel.setDireccion("Calle 10 # 23-05 Calle Real");
            hotel.setTelefono("31289036733");
            hotelServicio.actualizarHotel(hotel);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHotel(){
        try {
            hotelServicio.eliminarHotel(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHoteles(){
        List<Hotel> listaHoteles = hotelServicio.obtenerHoteles();
        listaHoteles.forEach(System.out::println);
    }
}
