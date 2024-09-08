package org.esfe.servicios.implementaciones;

import org.esfe.dtos.alumno.AlumnoGuardar;
import org.esfe.dtos.alumno.AlumnoModificar;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.modelos.Alumno;
import org.esfe.repositorios.IAlumnoRepository;
import org.esfe.servicios.interfaces.IAlumnoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService implements IAlumnoService {
    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AlumnoSalida> obtenerTodos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                .map(alumno -> modelMapper.map(alumno, AlumnoSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlumnoSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Alumno> page = alumnoRepository.findAll(pageable);
        List<AlumnoSalida> alumnosDto = page.stream()
                .map(alumno -> modelMapper.map(alumno, AlumnoSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(alumnosDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public AlumnoSalida obtenerPorId(Integer id) {
        return modelMapper.map(alumnoRepository.findById(id).get(), AlumnoSalida.class);
    }

    @Override
    public AlumnoSalida crear(AlumnoGuardar alumnoGuardar) {
        Alumno alumno = alumnoRepository.save(modelMapper.map(alumnoGuardar, Alumno.class));
        return  modelMapper.map(alumno, AlumnoSalida.class);
    }

    @Override
    public AlumnoSalida editar(AlumnoModificar alumnoModificar) {
        Alumno alumno = alumnoRepository.save(modelMapper.map(alumnoModificar, Alumno.class));

        return modelMapper.map(alumno, AlumnoSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        alumnoRepository.deleteById(id);

    }
}
