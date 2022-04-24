package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Reserva;

import java.util.List;

public interface ReservaServicio {

    /**
     * Permite la creación de una reserva
     * @param reserva
     * @return Objeto Reserva creada
     * @throws Exception
     */
    Reserva registrarReserva (Reserva reserva) throws Exception;

    /**
     * Permite actualizar una reserva
     * @param reserva
     * @return Objeto Reserva actualizada
     * @throws Exception
     */
    Reserva actualizarReserva (Reserva reserva) throws Exception;

    /**
     * Obtiene una reserva según su código
     * @param codigo
     * @return Objeto Reserva busqueda
     * @throws Exception
     */
    Reserva obtenerReserva (int codigo) throws Exception;

    /**
     * Elimina la reserva según el código indicado
     * @param codigo
     * @throws Exception
     */
    void eliminarReserva (int codigo) throws  Exception;

    /**
     * Obtiene la lista de reservas en estado Activo
     * @return Lista de reservas
     */
    List<Reserva> obtenerReservas();
}
