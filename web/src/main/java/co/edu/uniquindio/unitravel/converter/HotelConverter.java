package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class HotelConverter implements Converter<Hotel>, Serializable {

    private final HotelServicio hotelServicio;

    public HotelConverter(HotelServicio hotelServicio) {
        this.hotelServicio = hotelServicio;
    }


    @Override
    public Hotel getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            Hotel hotel = hotelServicio.obtenerHotel(Integer.parseInt(value));
            return hotel;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Hotel value) {

        if(value != null){
            return String.valueOf(value.getCodigo());
        }
        return "";
    }
}
