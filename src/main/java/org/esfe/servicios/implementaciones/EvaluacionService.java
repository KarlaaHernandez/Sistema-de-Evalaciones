package org.esfe.servicios.implementaciones;

import org.esfe.dtos.evalucion.EvaluacionGuardar;
import org.esfe.dtos.evalucion.EvaluacionModificar;
import org.esfe.dtos.evalucion.EvaluacionSalida;
import org.esfe.modelos.Evaluacion;
import org.esfe.repositorios.IEvaluacionRepository;
import org.esfe.servicios.interfaces.IEvaluacionService;
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
public class EvaluacionService implements IEvaluacionService {
    @Autowired
    private IEvaluacionRepository evaluacionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EvaluacionSalida> obtenerTodos() {
        List<Evaluacion> evaluaciones = evaluacionRepository.findAll();
        return evaluaciones.stream()
                .map(evaluacion -> modelMapper.map(evaluacion, EvaluacionSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<EvaluacionSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Evaluacion> page = evaluacionRepository.findAll(pageable);
        List<EvaluacionSalida> evaluacionesDto = page.stream()
                .map(evaluacion -> modelMapper.map(evaluacion, EvaluacionSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(evaluacionesDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public EvaluacionSalida obtenerPorId(Integer id) {
        Optional<Evaluacion> evaluacion = evaluacionRepository.findById(id);

        if (evaluacion.isPresent()) {
            return modelMapper.map(evaluacion.get(), EvaluacionSalida.class);
        }
        return null;
    }

    @Override
    public EvaluacionSalida crear(EvaluacionGuardar evaluacionGuardar) {
        Evaluacion evaluacion = modelMapper.map(evaluacionGuardar, Evaluacion.class);
        evaluacion.setId(null);
        return modelMapper.map(evaluacionRepository.save(evaluacion), EvaluacionSalida.class);
    }

    @Override
    public EvaluacionSalida editar(EvaluacionModificar evaluacionModificar) {
        Evaluacion evaluacion = evaluacionRepository.save(modelMapper.map(evaluacionModificar, Evaluacion.class));
        return modelMapper.map(evaluacion, EvaluacionSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        evaluacionRepository.deleteById(id);
    }
}
