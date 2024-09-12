package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.modelos.Criterio;
import org.esfe.repositorios.ICriterioRepository;
import org.esfe.servicios.interfaces.ICriterioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriterioService implements ICriterioService {

    @Autowired
    private ICriterioRepository criterioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CriterioSalida> obtenerTodos() {

        List<Criterio> criterios = criterioRepository.findAll();
        return criterios.stream()
                .map(criterio -> modelMapper.map(criterio, CriterioSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<CriterioSalida> obtenerTodosPaginados(Pageable pageable) {

        Page<Criterio> page = criterioRepository.findAll(pageable);
        List<CriterioSalida> criteriosDto = page.stream()
                .map(criterio -> modelMapper.map(criterio, CriterioSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(criteriosDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public CriterioSalida obtenerPorId(Integer id) {

        return modelMapper.map(criterioRepository.findById(id).get(), CriterioSalida.class);
    }

    @Override
    public CriterioSalida crear(CriterioGuardar criterioGuardar) {
        Criterio criterio = modelMapper.map(criterioGuardar, Criterio.class);
        criterio.setId(null);
        Criterio resp = criterioRepository.save(criterio);
        return  modelMapper.map(resp, CriterioSalida.class);
    }

    @Override
    public CriterioSalida editar(CriterioModificar criterioModificar) {

        Criterio criterio = criterioRepository.save(modelMapper.map(criterioModificar, Criterio.class));

        return modelMapper.map(criterio, CriterioSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        criterioRepository.deleteById(id);
    }
}
