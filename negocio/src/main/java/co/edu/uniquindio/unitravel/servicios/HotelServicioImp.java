package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServicioImp implements HotelServicio{

    private final HotelRepo hotelRepo;

    public HotelServicioImp (HotelRepo hotelRepo){
        this.hotelRepo = hotelRepo;
    }


    @Override
    public Hotel registrarHotel(Hotel hotel) throws Exception{

        Hotel hotelBusqueda = hotelRepo.obtenerHotelNit(hotel.getNit());
        if (hotelBusqueda != null)
            throw new Exception("El hotel " + hotel.getNombre() + " ya existe");
        if(hotel.getNumeroEstrellas() <= 0 )
            throw new Exception("El número de estrellas debe ser mayor a cero");
        if (hotel.getTelefono().length() > 10)
            throw new Exception("El número de teléfono excede el limite");
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel actualizarHotel(Hotel hotel) throws Exception{

        Hotel hotelBusqueda = hotelRepo.obtenerHotelNit(hotel.getNit());
        if (hotelBusqueda != null)
            throw new Exception("El hotel " + hotel.getNombre() + " ya existe");
        if(hotel.getNumeroEstrellas() <= 0 )
            throw new Exception("El número de estrellas debe ser mayor a cero");
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel obtenerHotel(int codigo) throws Exception {
        Hotel hotel = hotelRepo.findById(codigo).orElse(null);
        if(hotel == null){
            throw new Exception("El hotel "+ codigo + " no existe");
        }
        return hotel;
    }

    @Override
    public void eliminarHotel(int codigo) throws Exception {
        Hotel hotel = hotelRepo.findById(codigo).orElse(null);
        if(hotel == null){
            throw new Exception("El hotel "+ codigo + " no existe");
        }
         hotelRepo.delete(hotel);
    }

    @Override
    public List<Hotel> obtenerHoteles() {
        return hotelRepo.obtenerListaHoteles();
    }

    @Override
    public List<Hotel> obtenerHotelesPorDestino(String nombreCiudad) {
        return hotelRepo.obtenerHotelesNombre(nombreCiudad);
    }
}
