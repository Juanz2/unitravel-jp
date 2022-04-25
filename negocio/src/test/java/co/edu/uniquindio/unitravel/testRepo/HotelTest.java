package co.edu.uniquindio.unitravel.testRepo;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
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
   @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHotel(){
        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);
        if (ciudad!=null){
            Hotel hotel = new Hotel("Hotel Estelar", "489927666-7","Calle 9 #12-90","7468729", 5, ciudad, "A");
            Hotel hotelGuardado = hotelRepo.save(hotel);
            Assertions.assertNotNull(hotelGuardado);
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHotel(){
        Hotel hotel = hotelRepo.findById(1).orElse(null);
        if (hotel!=null){
            hotel.setDireccion("Calle 10 # 50-01");
            hotel.setNumeroEstrellas(4);
            hotel.setEstado("I");
            Hotel hotelActualizado = hotelRepo.save(hotel);
            Assertions.assertEquals("Calle 10 # 50-01", hotelActualizado.getDireccion());
        }
    }

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
        List<Hotel> listaHoteles = hotelRepo.obtenerHotelesNombre("Armenia");
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
       List<Hotel> hotelesSinComentario =  hotelRepo.ObtenerHotelesSinComentarios();
       Assertions.assertEquals(4, hotelesSinComentario.size());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelesPorNombre(){
        List<Hotel> hotelesNombre = hotelRepo.obtenerHotelesPorNombre("Eco");
        Assertions.assertEquals(1, hotelesNombre.size());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarHotelCiudad(){
        List<Hotel> listaHoteles = hotelRepo.obtenerHotelesCiudadOrdenado("Armenia");
        listaHoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void promedioCalificacionHotel(){
        List<Object[]> calificacion = hotelRepo.promedioCalificacionHotel();
        calificacion.forEach(c -> System.out.println(c[0]+"-"+c[1]));
    }
}
