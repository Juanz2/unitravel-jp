package co.edu.uniquindio.unitravel.testRepo;

import co.edu.uniquindio.unitravel.dto.ComentarioDto;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComentariosHoteles (){
        List<ComentarioDto> comentarios = comentarioRepo.comentariosHoteles();
        comentarios.forEach(System.out::println);
    }
}
