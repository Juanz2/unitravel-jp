package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearReserva(){
        Usuario usuario = usuarioRepo.findById("1094975931").orElse(null);
        LocalDateTime fechaReserva = LocalDateTime.parse("2022-04-14T18:14:01.184");
        LocalDateTime fechaInicio = LocalDateTime.parse("2022-04-20T20:12:04.184");
        if(usuario!=null){
            Reserva reserva = new Reserva(fechaReserva, fechaInicio, 250000.0, "Reservado", "A", 4, usuario);
            Reserva reservaGuardada = reservaRepo.save(reserva);
            Assertions.assertNotNull(reservaGuardada);
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarReserva(){
        Reserva reserva = reservaRepo.getById(1);
        if (reserva!=null){
            reserva.setEstado("I");
            reserva.setCantidadPersonas(3);
            reserva.setPrecioTotal(600000.0);
            Reserva reservaEdicion = reservaRepo.save(reserva);
            Assertions.assertNotNull(reservaEdicion);
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void numeroReservasHotel(){
        int numeroReservas = reservaRepo.numeroReservasHotel(1);
        System.out.println("Numero reservas: " + numeroReservas);
        Assertions.assertEquals(6,numeroReservas);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void calcularValorReservasUsuario(){
        double valorTotal = reservaRepo.calcularReservasTotalUsuario("1094975931");
        Assertions.assertEquals(920000,valorTotal);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerReservasPorUsuario(){
        List<Reserva> listaReservasUsuario = reservaRepo.listaReservasUsuario("1094975931");
        Assertions.assertEquals(3, listaReservasUsuario.size());
        listaReservasUsuario.forEach(System.out::println);
    }
}
