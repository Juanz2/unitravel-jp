package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaracteristicaTest {

    @Autowired
    private CaracteristicaRepo caracteristicaRepo;

    @Test
    public void crearCaracteristica(){

        Caracteristica caracteristica = new Caracteristica("El Hotel Oslo está situado en la Ciudad de México, a 20 minutos de la Zona Rosa, y ofrece WiFi gratuita y aparcamiento privado gratuito. También alberga un restaurante.", "A");
        Caracteristica caracteristicaGuardada = caracteristicaRepo.save(caracteristica);
        Assertions.assertNotNull(caracteristicaGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCaracteristica (){
        Caracteristica caracteristica = caracteristicaRepo.findById(1).orElse(null);
        if (caracteristica!=null){
            caracteristica.setNombre("Caracteristica del hotel, en ciudad de México");
            Caracteristica caracteristicaActualizada = caracteristicaRepo.save(caracteristica);
            Assertions.assertEquals(caracteristicaActualizada.getNombre(), "Caracteristica del hotel, en ciudad de México");
        }
    }

}
