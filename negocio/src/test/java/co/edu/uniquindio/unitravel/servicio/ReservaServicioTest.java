package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.ReservaServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
public class ReservaServicioTest {

    @Autowired
    private ReservaServicio reservaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarReserva() {
        try {
            Usuario usuario = usuarioServicio.obtenerUsuario("1094975931");
            LocalDateTime fechaReserva = LocalDateTime.parse("2022-04-14T18:14:01.184");
            LocalDateTime fechaInicio = LocalDateTime.parse("2022-04-20T20:12:04.184");
            LocalDateTime fechaFin = LocalDateTime.parse("2022-04-22T20:12:04.184");
            Reserva reserva = new Reserva(fechaReserva, fechaInicio, fechaFin, 9000000.0, "Reservado", "A", 2, usuario);
            reservaServicio.registrarReserva(reserva);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarReserva() {
        try {
            Reserva reserva = reservaServicio.obtenerReserva(1);
            reserva.setEstadoReserva("I");
            reserva.setPrecioTotal(8900000.0);
            reservaServicio.actualizarReserva(reserva);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarReserva() {
        try {
            reservaServicio.eliminarReserva(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservas() {
        List<Reserva> reservas = reservaServicio.obtenerReservas();
        reservas.forEach(System.out::println);
    }
}
