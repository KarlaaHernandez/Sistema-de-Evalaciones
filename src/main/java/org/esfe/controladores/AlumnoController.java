package org.esfe.controladores;

import org.apache.coyote.Response;
import org.esfe.dtos.alumno.AlumnoGuardar;
import org.esfe.dtos.alumno.AlumnoModificar;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.servicios.interfaces.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<Page<AlumnoSalida>> mostrarTodoPaginados(Pageable pageable){
        Page<AlumnoSalida> alumnos = alumnoService.obtenerTodosPaginados(pageable);
        if(alumnos.hasContent()) {
            return ResponseEntity.ok(alumnos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<AlumnoSalida>> mostrarTodos() {
        List<AlumnoSalida> alumnos = alumnoService.obtenerTodos();
        if(!alumnos.isEmpty()) {
            return ResponseEntity.ok(alumnos);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoSalida> buscarPorId(@PathVariable Integer id){
        AlumnoSalida alumno = alumnoService.obtenerPorId(id);
        if(alumno != null){
            return ResponseEntity.ok(alumno);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AlumnoSalida> crear(@RequestBody AlumnoGuardar alumnoGuardar){
        AlumnoSalida alumno = alumnoService.crear(alumnoGuardar);
        return ResponseEntity.ok(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoSalida> editar(@PathVariable Integer id, @RequestBody AlumnoModificar alumnoModificar){
        AlumnoSalida alumno = alumnoService.editar(alumnoModificar);
        return ResponseEntity.ok(alumno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        alumnoService.eliminarPorId(id);
        return ResponseEntity.ok("Alumno eliminado correctamente");
    }

}
