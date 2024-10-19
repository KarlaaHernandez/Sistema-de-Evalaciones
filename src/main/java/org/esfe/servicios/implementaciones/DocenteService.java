package org.esfe.servicios.implementaciones;


import org.esfe.dtos.docente.DocenteGuardar;
import org.esfe.dtos.docente.DocenteModificar;
import org.esfe.dtos.docente.DocenteSalida;
import org.esfe.modelos.Docente;

import org.esfe.repositorios.IDocenteRepository;
import org.esfe.servicios.interfaces.IDocenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteService implements IDocenteService {
    @Autowired
    private IDocenteRepository docenteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DocenteSalida> obtenerTodos() {
        List<Docente> docentes = docenteRepository.findAll();
        return docentes.stream()
                .map(docente -> modelMapper.map(docente, DocenteSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<DocenteSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Docente> page = docenteRepository.findAll(pageable);
        List<DocenteSalida> docentesDto = page.stream()
                .map(docente -> modelMapper.map(docente, DocenteSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(docentesDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public DocenteSalida obtenerPorId(Integer id) {
        return modelMapper.map(docenteRepository.findById(id).get(), DocenteSalida.class);
    }

    @Override
    public DocenteSalida crear(DocenteGuardar docenteGuardar) {
        Docente docente = docenteRepository.save(modelMapper.map(docenteGuardar, Docente.class));
        return  modelMapper.map(docente, DocenteSalida.class);
    }

    @Override
    public DocenteSalida editar(DocenteModificar docenteModificar) {
        Docente docente = docenteRepository.save(modelMapper.map(docenteModificar, Docente.class));

        return modelMapper.map(docente, DocenteSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        docenteRepository.deleteById(id);

    }
}
