package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.ComentarioServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@ViewScoped
public class DetalleHotelBean implements Serializable {


    @Autowired
    private HotelServicio hotelServicio;

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Value("#{param['hotelId']}")
    private String parametroBusqueda;


    @Getter
    @Setter
    private Hotel hotel;

    @Getter
    @Setter
    private Comentario comentario;

    @Value(value = "#{seguridadBean.usuario}")
    private Usuario usuarioSesion;

    @Getter @Setter
    private List<Comentario> comentariosHotel;

    @PostConstruct
    public void init() {
        comentario = new Comentario();

        if (parametroBusqueda != null) {
            try {
                hotel = hotelServicio.obtenerHotel(Integer.parseInt(parametroBusqueda));
                comentariosHotel = comentarioServicio.obtenerComentariosHotel(hotel.getCodigo());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * Permite registrar el comentario al hotel
     */
    public void registrarComentario() {

        try {
            Hotel hotelComentario = hotelServicio.obtenerHotel(Integer.parseInt(parametroBusqueda));
            comentario.setHotel(hotelComentario);
            comentario.setUsuario(usuarioSesion);
            comentario.setEstado("A");
            comentario.setFechaCalificacion(LocalDateTime.now());
            comentarioServicio.registrarComentario(comentario);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Procesado correctamente");
            FacesContext.getCurrentInstance().addMessage("comentario-bean", fm);
            comentariosHotel = comentarioServicio.obtenerComentariosHotel(hotelComentario.getCodigo());
        } catch (Exception e) {
            e.getStackTrace();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("comentario-bean", fm);
        }
    }

    /**
     * Obtiene fecha de comentario en formato yyyy-MM-dd HH:mm:ss
     * @param comentario
     * @return
     */
    public String obtenerFechaComentario(Comentario comentario){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return comentario.getFechaCalificacion().format(formato);
    }
}
