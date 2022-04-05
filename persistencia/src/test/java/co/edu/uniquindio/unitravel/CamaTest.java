package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.CamaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CamaTest {

    @Autowired
    private CamaRepo camaRepo;
    @Test
    public void registrar(){

        Cama cama = new Cama(1,"Doble");
        Cama camaGuardada = camaRepo.save(cama);
        Assertions.assertNotNull(camaGuardada);
    }

    @Test
    public void eliminar (){
        Cama cama = new Cama(1,"Doble");
        Cama camaGuardada = camaRepo.save(cama);

        camaRepo.delete(camaGuardada);
        Cama camaBusqueda = camaRepo.findById(1).orElse(null);

        Assertions.assertNull(camaBusqueda);
    }


    @Test
    public void actualizar() {
        Cama cama = new Cama(2, "Doble XXL");
        Cama camaGuardada = camaRepo.save(cama);
        camaGuardada.setTipo("Extra grande");
        camaRepo.save(camaGuardada);
        Cama camaBusqueda = camaRepo.findById(2).orElse(null);
        Assertions.assertEquals("287363/2**", camaBusqueda.getTipo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cama> listaCamas = camaRepo.findAll();
        System.out.println("Camas: \n" + listaCamas);
    }



}
