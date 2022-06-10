package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.servicios.CamaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CamaConverter implements Converter<Cama>, Serializable {


    @Autowired
    private CamaServicio camaServicio;

    @Override
    public Cama getAsObject(FacesContext context, UIComponent component, String value) {

        Cama cama = camaServicio.obtenerCama(Integer.parseInt(value));

        return cama;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Cama value) {

        if (value != null) {
            return String.valueOf(value.getCodigo());
        }
        return "";
    }
}
