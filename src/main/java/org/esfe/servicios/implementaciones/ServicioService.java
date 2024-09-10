package org.esfe.servicios.implementaciones;

import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.dtos.servicio.ServicioGuardar;
import org.esfe.dtos.servicio.ServicioModificar;
import org.esfe.dtos.servicio.ServicioSalida;
import org.esfe.modelos.Alumno;
import org.esfe.modelos.Servicio;
import org.esfe.repositorios.IServicioRepository;
import org.esfe.servicios.interfaces.IServicioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioService  implements IServicioService {

    @Autowired
    private IServicioRepository servicioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ServicioSalida> obtenerTodos() {
        List<Servicio> servicios = servicioRepository.findAll();
        return servicios.stream()
                .map(servicio -> modelMapper.map(servicio, ServicioSalida.class))
                .collect(Collectors.toList());
    }



    @Override
    public Page<ServicioSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Servicio> page = servicioRepository.findAll(pageable);
        List<ServicioSalida> serviciosDto = page.stream()
                .map(servicio -> modelMapper.map(servicio, ServicioSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(serviciosDto, page.getPageable(), page.getTotalElements());

    }

    @Override
    public ServicioSalida obtenerPorId(Integer id) {
        Optional<Servicio> servicio = servicioRepository.findById(id);

        if(servicio.isPresent()){
            return modelMapper.map(servicio.get(), ServicioSalida.class);

        }
        return  null;
    }

    @Override
    public ServicioSalida crear(ServicioGuardar servicioGuardar) {
        Servicio servicio = modelMapper.map(servicioGuardar, Servicio.class);
        servicio.setId(null);

        return modelMapper.map(servicioRepository.save(servicio), ServicioSalida.class);
    }
    @Override
    public ServicioSalida editar(ServicioModificar servicioModificar) {
        Servicio servicio = servicioRepository.save(modelMapper.map(servicioModificar, Servicio.class));

        return modelMapper.map(servicio, ServicioSalida.class);

    }

    @Override
    public void eliminarPorId(Integer id) {

        servicioRepository.deleteById(id);
    }
}
