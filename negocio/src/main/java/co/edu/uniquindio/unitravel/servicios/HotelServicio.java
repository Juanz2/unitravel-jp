package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;

import java.util.List;

public interface HotelServicio {

    /**
     * Permite crear un hotel
     * @param hotel
     * @return Hotel creado
     */
    Hotel registrarHotel (Hotel hotel) throws Exception;

    /**
     * Permite actualizar un hotel
     * @param hotel
     * @return Objeto hotel actualizado
     */
    Hotel actualizarHotel (Hotel hotel) throws Exception;

    /**
     * Obtiene el hotel por el código indicado
     * @param codigo
     * @return Objeto Hotel
     * @throws Exception
     */
    Hotel obtenerHotel (int codigo) throws Exception;

    /**
     * Permite la eliminación del hotel
     * @param codigo
     * @throws Exception
     */
    void eliminarHotel (int codigo) throws  Exception;

    /**
     * Obtiene los hoteles en estado Activo
     * @return Lista de hoteles
     */
    List<Hotel> obtenerHoteles();
}
