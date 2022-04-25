package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;

import java.util.List;

public interface HotelServicio {


    Hotel registrarHotel (Hotel hotel) throws Exception;

    Hotel actualizarHotel (Hotel hotel) throws Exception;

    Hotel obtenerHotel (int codigo) throws Exception;


    void eliminarHotel (int codigo) throws  Exception;


    List<Hotel> obtenerHoteles();

    List<Hotel> obtenerHotelesPorDestino(String nombreCiudad);
}
