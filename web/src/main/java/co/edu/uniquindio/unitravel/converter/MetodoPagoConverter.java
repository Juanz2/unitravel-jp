package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.MetodoPago;
import co.edu.uniquindio.unitravel.servicios.MetodoPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class MetodoPagoConverter implements Converter<MetodoPago>, Serializable {

    @Autowired
    private MetodoPagoServicio metodoPagoServicio;

    @Override
    public MetodoPago getAsObject(FacesContext context, UIComponent component, String value) {
        MetodoPago metodoPago = metodoPagoServicio.obtenerMetodoPago(Integer.parseInt(value));
        return metodoPago;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, MetodoPago value) {

        if (value != null) {
            return String.valueOf(value.getCodigo());
        }
        return "";
    }
}
