package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CiudadConverter implements Converter<Ciudad>, Serializable {

    private final UnitravelServicio unitravelServicio;
    private final CiudadServicio ciudadServicio;

    public CiudadConverter(UnitravelServicio unitravelServicio, CiudadServicio ciudadServicio) {
        this.unitravelServicio = unitravelServicio;
        this.ciudadServicio = ciudadServicio;
    }


    @Override
    public Ciudad getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Ciudad ciudad = ciudadServicio.obtenerCiudad(Integer.parseInt(value));
            return ciudad;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Ciudad value) {
        if (value != null) {
            return String.valueOf(value.getCodigo());
        }
        return "";
    }
}
