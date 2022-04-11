package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloTest {

    @Autowired
    private VueloRepo vueloRepo;

}
