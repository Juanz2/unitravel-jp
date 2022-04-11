package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Hotel;
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
public class HotelTest {

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar(){

        Hotel hotel = hotelRepo.findById(1).orElse(null);
        System.out.println(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelCategoria(){

        List<Hotel> hoteles = hotelRepo.obtenerHotelCategoria(3);
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudadHotel (){
        String nombreCiudadHotel = hotelRepo.obtenerNombreCiudad(3);
        //System.out.println("Ciudad: " + nombreCiudadHotel);
        Assertions.assertEquals("Cartagena", nombreCiudadHotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerListaHotelCiudad (){
        List<Hotel> listaHoteles = hotelRepo.obtenerHoteles("Armenia");
        System.out.println("Hoteles: " + listaHoteles);
        Assertions.assertEquals(2, listaHoteles.size());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void contarCantidadHotelesCiudad(){
        List<Object []> listaHotelesCiudad = hotelRepo.contarHotelesPorCiudad();
        listaHotelesCiudad.forEach(c -> System.out.println(c[0]+"-"+c[1]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelesSinComentario(){
       List<Hotel> hotelesSinComentario =  hotelRepo.ObtenerhotelesSinComentarios();
       Assertions.assertEquals(4, hotelesSinComentario.size());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelesPorNombre(){
        List<Hotel> hotelesNombre = hotelRepo.obtenerHotelesPorNombre("Eco");
        Assertions.assertEquals(1, hotelesNombre.size());
    }
}
