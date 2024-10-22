package org.esfe.servicios.implementaciones;

import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteGuardar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteModificar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteSalida;
import org.esfe.modelos.EvaluacionDocente;
import org.esfe.repositorios.IEvaluacionDocenteRepository;
import org.esfe.servicios.interfaces.IEvaluacionDocenteService;
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
public class EvaluacionDocenteService implements IEvaluacionDocenteService {
    @Autowired
    private IEvaluacionDocenteRepository evaluaciondocenteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EvaluacionDocenteSalida> obtenerTodos() {
        List<EvaluacionDocente> evaluacionesdocentes = evaluaciondocenteRepository.findAll();
        return evaluacionesdocentes.stream()
                .map(evaluacionesdocente -> modelMapper.map(evaluacionesdocente, EvaluacionDocenteSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<EvaluacionDocenteSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<EvaluacionDocente> page = evaluaciondocenteRepository.findAll(pageable);
        List<EvaluacionDocenteSalida> evaluacionesDto = page.stream()
                .map(evaluacionesdocente -> modelMapper.map(evaluacionesdocente, EvaluacionDocenteSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(evaluacionesDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public EvaluacionDocenteSalida obtenerPorId(Integer id) {
        Optional<EvaluacionDocente> evaluacionesdocente = evaluaciondocenteRepository.findById(id);

        if (evaluacionesdocente.isPresent()) {
            return modelMapper.map(evaluacionesdocente.get(), EvaluacionDocenteSalida.class);
        }
        return null;
    }

    @Override
    public EvaluacionDocenteSalida crear(EvaluacionDocenteGuardar evaluaciondocenteGuardar) {
        try {
            EvaluacionDocente evaluaciondocente = modelMapper.map(evaluaciondocenteGuardar, EvaluacionDocente.class);
            evaluaciondocente.setId(null);
            return modelMapper.map(evaluaciondocenteRepository.save(evaluaciondocente), EvaluacionDocenteSalida.class);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        return null;
    }

    @Override
    public EvaluacionDocenteSalida editar(EvaluacionDocenteModificar evaluaciondocenteModificar) {
        EvaluacionDocente evaluaciondocente = evaluaciondocenteRepository.save(modelMapper.map(evaluaciondocenteModificar, EvaluacionDocente.class));
        return modelMapper.map(evaluaciondocente, EvaluacionDocenteSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        evaluaciondocenteRepository.deleteById(id);
    }
}
