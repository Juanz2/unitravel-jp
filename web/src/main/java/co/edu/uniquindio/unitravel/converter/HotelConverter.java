package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class HotelConverter implements Converter<Hotel>, Serializable {

    @Autowired
    private HotelServicio hotelServicio;


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
           return value.getCodigo().toString();
       }
       return "";
    }
}
