package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.MetodoPago;

import java.util.List;

public interface MetodoPagoServicio {

    MetodoPago registrarMetodoPago(MetodoPago metodoPago) ;
    MetodoPago actualizarMetodoPago(MetodoPago metodoPago);
    List<MetodoPago> obtenerMetodosPago () throws Exception;
    MetodoPago obtenerMetodoPago(int codigo);
    void eliminarMetodoPago(int codigo)throws Exception;

}
