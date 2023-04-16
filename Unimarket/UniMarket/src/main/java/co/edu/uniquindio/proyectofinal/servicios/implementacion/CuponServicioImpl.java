package co.edu.uniquindio.proyectofinal.servicios.implementacion;

import co.edu.uniquindio.proyectofinal.dto.CuponDTO;
import co.edu.uniquindio.proyectofinal.dto.CuponGetDTO;
import co.edu.uniquindio.proyectofinal.modelo.Cupon;
import co.edu.uniquindio.proyectofinal.repositorios.CuponRepo;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.CompraServicio;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.CuponServicio;
import co.edu.uniquindio.proyectofinal.servicios.inferfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CuponServicioImpl  implements CuponServicio {

    private final CuponRepo cuponRepo;

    private final UsuarioServicio usuarioServicio;

    private final CompraServicio compraServicio;

    @Override
    public int crearCupon(CuponDTO cuponDTO) throws Exception{

        Cupon cupon = new Cupon();
        cupon.setCodigoCupon(cuponDTO.getCodigoCupon());
        cupon.setPorcentaje(cuponDTO.getPorcentaje());
        cupon.setFechaLimite(LocalDate.now());
        cupon.setUsuarioCupon( usuarioServicio.obtenerCupon(cuponDTO.getCodigoCupon()));
        cupon.setCompraCupon(compraServicio.obtenerCompra(cuponDTO.getCodoigoCompra()));

        return cuponRepo.save(cupon).getCodigoCupon();
    }

    @Override
    public CuponGetDTO actualizarCupon(int codigoCupon, CuponDTO cuponDTO) throws Exception {
        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(codigoCupon);

        Cupon cupon = convertir(cuponDTO);
        cupon.setCodigoCupon(codigoCupon);

        return convertir(cuponRepo.save(cupon));
    }

    private Cupon convertir(CuponDTO cuponDTO) throws Exception {
        Cupon cupon = new Cupon();
        cupon.setCodigoCupon(cuponDTO.getCodigoCupon());
        cupon.setPorcentaje(cuponDTO.getPorcentaje());
        cupon.setFechaLimite(LocalDate.now());
        cupon.setUsuarioCupon( usuarioServicio.obtenerCupon(cuponDTO.getCodigoCupon()));
        cupon.setCompraCupon(compraServicio.obtenerCompra(cuponDTO.getCodoigoCompra()));

        return cupon;
    }

    private CuponGetDTO convertir(Cupon cupon){

        CuponGetDTO cuponDTO = new CuponGetDTO(
                cupon.getCodigoCupon(),
                cupon.getPorcentaje(),
                cupon.getFechaLimite(),
                cupon.getUsuarioCupon(),
                cupon.getCompraCupon());

        return cuponDTO;
    }

    private void validarExiste(int codigoCupon) throws Exception{
        boolean existe = cuponRepo.existsById(codigoCupon);

        if (!existe){
            throw new Exception("El codigo "+codigoCupon+"no esta asciado a ningun cupon");
        }
    }

    @Override
    public int eliminiarCupon(int codigoCupon) throws Exception {

        validarExiste(codigoCupon);
        cuponRepo.deleteById(codigoCupon);
        return codigoCupon;
    }

    @Override
    public CuponGetDTO obtenerCupon(int codigoCupon) throws Exception {
        return convertir(obtener(codigoCupon));
    }

    @Override
    public Cupon obtener(int codigoCupon) throws Exception {
        Optional<Cupon> cupon = cuponRepo.findById(codigoCupon);

        if (cupon.isEmpty()){
            throw new Exception("El código "+codigoCupon+" no está asociado a ningún cupon");
        }

        return cupon.get();
    }
}
