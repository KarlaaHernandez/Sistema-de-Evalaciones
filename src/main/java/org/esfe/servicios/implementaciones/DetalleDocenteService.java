package org.esfe.servicios.implementaciones;

import org.esfe.dtos.detalleDocente.DetalleDocenteGuardar;
import org.esfe.dtos.detalleDocente.DetalleDocenteModificar;
import org.esfe.dtos.detalleDocente.DetalleDocenteSalida;
import org.esfe.modelos.DetalleDocente;
import org.esfe.repositorios.IDetalleDocenteRepository;
import org.esfe.servicios.interfaces.IDetalleDocenteService;
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
public class DetalleDocenteService implements IDetalleDocenteService {
    @Autowired
    private IDetalleDocenteRepository detalleDocenteRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<DetalleDocenteSalida> obtenerTodos() {
        List<DetalleDocente> detallesDocente = detalleDocenteRepository.findAll();
        return detallesDocente.stream()
                .map(detalleDocente -> modelMapper.map(detalleDocente, DetalleDocenteSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<DetalleDocenteSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<DetalleDocente> page = detalleDocenteRepository.findAll(pageable);
        List<DetalleDocenteSalida> detallesDocenteDto = page.stream()
                .map(detalleDocente -> modelMapper.map(detalleDocente, DetalleDocenteSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(detallesDocenteDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public DetalleDocenteSalida obtenerPorId(Integer id) {
        Optional<DetalleDocente> detalleDocente = detalleDocenteRepository.findById(id);

        if (detalleDocente.isPresent()) {
            return modelMapper.map(detalleDocente.get(), DetalleDocenteSalida.class);
        }
        return null;
    }

    @Override
    public DetalleDocenteSalida crear(DetalleDocenteGuardar detalleDocenteGuardar) {
        try {
            DetalleDocente detalleDocente = modelMapper.map(detalleDocenteGuardar, DetalleDocente.class);
            detalleDocente.setId(null);
            DetalleDocente resp = detalleDocenteRepository.save(detalleDocente);
            return modelMapper.map(detalleDocente, DetalleDocenteSalida.class);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public DetalleDocenteSalida editar(DetalleDocenteModificar detalleDocenteModificar) {
        DetalleDocente detalleDocente = detalleDocenteRepository.save(modelMapper.map(detalleDocenteModificar, DetalleDocente.class));
        return modelMapper.map(detalleDocente, DetalleDocenteSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {detalleDocenteRepository.deleteById(id);    }
}
