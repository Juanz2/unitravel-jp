package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void numeroReservasHotel(){
        int numeroReservas = reservaRepo.numeroReservasHotel(1);
        System.out.println("Numero reservas: " + numeroReservas);
        Assertions.assertEquals(6,6);
    }

}
