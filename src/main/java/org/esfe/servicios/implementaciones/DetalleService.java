package org.esfe.servicios.implementaciones;

import org.esfe.dtos.detalle.DetalleGuardar;
import org.esfe.dtos.detalle.DetalleModificar;
import org.esfe.dtos.detalle.DetalleSalida;
import org.esfe.dtos.evalucion.EvaluacionSalida;
import org.esfe.modelos.Detalle;
import org.esfe.repositorios.IDetalleRepository;
import org.esfe.servicios.interfaces.IDetalleService;
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
public class DetalleService implements IDetalleService {
    @Autowired
    private IDetalleRepository detalleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DetalleSalida> obtenerTodos() {
        List<Detalle> detalles = detalleRepository.findAll();
        return detalles.stream()
                .map(detalle -> modelMapper.map(detalle, DetalleSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<DetalleSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Detalle> page = detalleRepository.findAll(pageable);
        List<DetalleSalida> detallesDto = page.stream()
                .map(detalle -> modelMapper.map(detalle, DetalleSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(detallesDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public DetalleSalida obtenerPorId(Integer id) {
        Optional<Detalle> detalle = detalleRepository.findById(id);

        if (detalle.isPresent()) {
            return modelMapper.map(detalle.get(), DetalleSalida.class);
        }
        return null;
    }

    @Override
    public DetalleSalida crear(DetalleGuardar detalleGuardar) {
        Detalle detalle = modelMapper.map(detalleGuardar, Detalle.class);
        return modelMapper.map(detalleRepository.save(detalle), DetalleSalida.class);
    }

    @Override
    public DetalleSalida editar(DetalleModificar detalleModificar) {
        Detalle detalle = detalleRepository.save(modelMapper.map(detalleModificar, Detalle.class));
        return modelMapper.map(detalle, DetalleSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        detalleRepository.deleteById(id);
    }
}
