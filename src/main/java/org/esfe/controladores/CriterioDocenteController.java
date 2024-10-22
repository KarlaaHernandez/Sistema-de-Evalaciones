package org.esfe.controladores;
//esto es una prueba
import org.esfe.dtos.criterioDocente.CriterioDocenteGuardar;
import org.esfe.dtos.criterioDocente.CriterioDocenteModificar;
import org.esfe.dtos.criterioDocente.CriterioDocenteSalida;
import org.esfe.servicios.interfaces.ICriterioDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criteriosDocente")

public class CriterioDocenteController {

    @Autowired
    private ICriterioDocenteService criterioDocenteService;

    @GetMapping
    public ResponseEntity<Page<CriterioDocenteSalida>> mostrarTodoPaginados(Pageable pageable){
        Page<CriterioDocenteSalida> criteriosDocente = criterioDocenteService.obtenerTodosPaginados(pageable);
        if(criteriosDocente.hasContent()) {
            return ResponseEntity.ok(criteriosDocente);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<CriterioDocenteSalida>> mostrarTodos() {
        List<CriterioDocenteSalida> criteriosDocente = criterioDocenteService.obtenerTodos();
        if(!criteriosDocente.isEmpty()) {
            return ResponseEntity.ok(criteriosDocente);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriterioDocenteSalida> buscarPorId(@PathVariable Integer id){
        CriterioDocenteSalida criterioDocente = criterioDocenteService.obtenerPorId(id);
        if(criterioDocente != null){
            return ResponseEntity.ok(criterioDocente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CriterioDocenteSalida> crear(@RequestBody CriterioDocenteGuardar criterioDocenteGuardar){
        CriterioDocenteSalida criterioDocente = criterioDocenteService.crear(criterioDocenteGuardar);
        return ResponseEntity.ok(criterioDocente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriterioDocenteSalida> editar(@PathVariable Integer id, @RequestBody CriterioDocenteModificar criterioDocenteModificar){
        CriterioDocenteSalida criterioDocente = criterioDocenteService.editar(criterioDocenteModificar);
        if(criterioDocente != null){
            return ResponseEntity.ok(criterioDocente);
        }

        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        criterioDocenteService.eliminarPorId(id);
        return ResponseEntity.ok("criterioDocente eliminado correctamente");
    }
}
