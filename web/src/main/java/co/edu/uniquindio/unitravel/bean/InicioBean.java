package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    private String mensaje = "Primera pagina";

    @Autowired
    private HotelServicio hotelServicio;

    @Autowired
    private CiudadServicio ciudadServicio;

    @Getter @Setter
    private List<Hotel> listaHoteles;

    @Getter @Setter
    private List<Ciudad> listaCiudades;

    @PostConstruct
    public void init(){
        listaHoteles = hotelServicio.obtenerHoteles();
        listaCiudades = ciudadServicio.listarCiudades();
    }

}
