package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.MetodoPago;
import co.edu.uniquindio.unitravel.repositorios.MetodoPagoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoServicioImp implements  MetodoPagoServicio{

    private final MetodoPagoRepo metodoPagoRepo;

    public MetodoPagoServicioImp(MetodoPagoRepo metodoPagoRepo) {
        this.metodoPagoRepo = metodoPagoRepo;
    }


    @Override
    public MetodoPago registrarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepo.save(metodoPago);
    }

    @Override
    public MetodoPago actualizarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepo.save(metodoPago);
    }

    @Override
    public List<MetodoPago> obtenerMetodosPago() {
        return metodoPagoRepo.findAll();
    }

    @Override
    public MetodoPago obtenerMetodoPago(int codigo)  {
        return metodoPagoRepo.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarMetodoPago(int codigo) throws Exception{
        MetodoPago metodoPago = obtenerMetodoPago(codigo);
        if(metodoPago != null){
            metodoPagoRepo.delete(metodoPago);
        }else{
            throw new Exception("No se encuentra el metodo de pago");
        }
    }
}
