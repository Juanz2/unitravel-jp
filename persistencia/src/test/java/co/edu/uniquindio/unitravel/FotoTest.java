package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Foto;
import co.edu.uniquindio.unitravel.repositorios.FotoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FotoTest {

    @Autowired
    private FotoRepo fotoRepo;

    @Test
    public void crearFoto(){
        Foto foto = new Foto(1, "www.google.com", "A");
        Foto fotoGuardada = fotoRepo.save(foto);
        Assertions.assertNotNull(fotoGuardada);
    }
    @Test
    @Sql("classpath:dataset.sql")
    /**
     * Actualización de fotos
     */
    public void actualizarFoto() {
        Foto fotoActualizar = fotoRepo.findById(1).orElse(null);
        if (fotoActualizar != null) {
            fotoActualizar.setEstado("I");
            fotoActualizar.setUrl("www.unitravel.com");
            Foto fotoActualizada = fotoRepo.save(fotoActualizar);
            Assertions.assertEquals("www.unitravel.com",fotoActualizada.getUrl());
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    /**
     * Se listan las fotos
     */
    public void listarFotos (){
        List<Foto> listaFotos = fotoRepo.obtenerFotos();
        listaFotos.forEach(System.out::println);
    }
}
