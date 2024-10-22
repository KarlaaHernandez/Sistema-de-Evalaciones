package org.esfe.controladores;

import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteGuardar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteModificar;
import org.esfe.dtos.evaluaciondocente.EvaluacionDocenteSalida;
import org.esfe.servicios.interfaces.IEvaluacionDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluacionesdocente")
public class EvaluacionDocenteController {
    @Autowired
    private IEvaluacionDocenteService evaluaciondocenteService;

    @GetMapping
    public ResponseEntity<Page<EvaluacionDocenteSalida>> mostrarTodoPaginados(Pageable pageable) {
        Page<EvaluacionDocenteSalida> evaluacionesdocentes = evaluaciondocenteService.obtenerTodosPaginados(pageable);
        if (evaluacionesdocentes.hasContent()) {
            return ResponseEntity.ok(evaluacionesdocentes);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<EvaluacionDocenteSalida>> mostrarTodos() {
        List<EvaluacionDocenteSalida> evaluacionesdocentes = evaluaciondocenteService.obtenerTodos();
        if (!evaluacionesdocentes.isEmpty()) {
            return ResponseEntity.ok(evaluacionesdocentes);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionDocenteSalida> mostrarPorId(@PathVariable Integer id) {
        EvaluacionDocenteSalida evaluacionesdocente = evaluaciondocenteService.obtenerPorId(id);
        if (evaluacionesdocente != null) {
            return ResponseEntity.ok(evaluacionesdocente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EvaluacionDocenteSalida> crear(@RequestBody EvaluacionDocenteGuardar evaluaciondocenteGuardar) {
        EvaluacionDocenteSalida evaluacionesdocente = evaluaciondocenteService.crear(evaluaciondocenteGuardar);
        if (evaluacionesdocente != null) {
            return ResponseEntity.ok(evaluacionesdocente);
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionDocenteSalida> editar(@PathVariable Integer id, @RequestBody EvaluacionDocenteModificar evaluaciondocenteModificar) {
        EvaluacionDocenteSalida evaluacionesdocente = evaluaciondocenteService.editar(evaluaciondocenteModificar);
        return ResponseEntity.ok(evaluacionesdocente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        evaluaciondocenteService.eliminarPorId(id);
        return ResponseEntity.ok("Evaluación del docente eliminada correctamente");
    }
}
