package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    @Getter
    @Setter
    private String busqueda;
    @Autowired
    private HotelServicio hotelServicio;

    @Value("#{param['busqueda']}")
    private String parametroBusqueda;

    @Getter
    @Setter
    private List<Hotel> hotelesBusqueda;

    @PostConstruct
    public void inicializar(){
        if(parametroBusqueda != null && !parametroBusqueda.isEmpty()){
            hotelesBusqueda = hotelServicio.obtenerHotelesPorDestino(parametroBusqueda);
        }else{
            hotelesBusqueda = new ArrayList<>();
        }
    }
    public String buscar(){
        return "resultadoBusqueda?faces-redirect=true&amp;busqueda=" + busqueda;
    }
}
