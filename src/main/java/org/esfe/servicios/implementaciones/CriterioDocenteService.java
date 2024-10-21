package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterioDocente.CriterioDocenteGuardar;
import org.esfe.dtos.criterioDocente.CriterioDocenteModificar;
import org.esfe.dtos.criterioDocente.CriterioDocenteSalida;
import org.esfe.modelos.CriterioDocente;
import org.esfe.repositorios.ICriterioDocenteRepository;
import org.esfe.servicios.interfaces.ICriterioDocenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriterioDocenteService implements ICriterioDocenteService {


    @Autowired
    private ICriterioDocenteRepository criterioDocenteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CriterioDocenteSalida> obtenerTodos() {

        List<CriterioDocente> criteriosDocente = criterioDocenteRepository.findAll();
        return criteriosDocente.stream()
                .map(criterioDocente -> modelMapper.map(criterioDocente, CriterioDocenteSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<CriterioDocenteSalida> obtenerTodosPaginados(Pageable pageable) {

        Page<CriterioDocente> page = criterioDocenteRepository.findAll(pageable);
        List<CriterioDocenteSalida> criteriosDocenteDto = page.stream()
                .map(criterioDocente -> modelMapper.map(criterioDocente, CriterioDocenteSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(criteriosDocenteDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public CriterioDocenteSalida obtenerPorId(Integer id) {
        CriterioDocente criterioDocente = criterioDocenteRepository.findById(id).get();
        return modelMapper.map(criterioDocente, CriterioDocenteSalida.class);
    }

    @Override
    public CriterioDocenteSalida crear(CriterioDocenteGuardar criterioDocenteGuardar) {
        CriterioDocente criterioDocente = modelMapper.map(criterioDocenteGuardar, CriterioDocente.class);
        criterioDocente.setId(null);
        CriterioDocente resp = criterioDocenteRepository.save(criterioDocente);
        return  modelMapper.map(resp, CriterioDocenteSalida.class);
    }

    @Override
    public CriterioDocenteSalida editar(CriterioDocenteModificar criterioDocenteModificar) {

        CriterioDocente criterioDocente = criterioDocenteRepository.save(modelMapper.map(criterioDocenteModificar, CriterioDocente.class));

        return modelMapper.map(criterioDocente, CriterioDocenteSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        criterioDocenteRepository.deleteById(id);
    }
}

