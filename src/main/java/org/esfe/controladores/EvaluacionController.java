package org.esfe.controladores;

import org.esfe.dtos.evalucion.EvaluacionGuardar;
import org.esfe.dtos.evalucion.EvaluacionModificar;
import org.esfe.dtos.evalucion.EvaluacionSalida;
import org.esfe.servicios.interfaces.IEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {
    @Autowired
    private IEvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<Page<EvaluacionSalida>> mostrarTodoPaginados(Pageable pageable) {
        Page<EvaluacionSalida> evaluaciones = evaluacionService.obtenerTodosPaginados(pageable);
        if (evaluaciones.hasContent()) {
            return ResponseEntity.ok(evaluaciones);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<EvaluacionSalida>> mostrarTodos() {
        List<EvaluacionSalida> evaluaciones = evaluacionService.obtenerTodos();
        if (!evaluaciones.isEmpty()) {
            return ResponseEntity.ok(evaluaciones);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionSalida> mostrarPorId(@PathVariable Integer id) {
        EvaluacionSalida evaluacion = evaluacionService.obtenerPorId(id);
        if (evaluacion != null) {
            return ResponseEntity.ok(evaluacion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EvaluacionSalida> crear(@RequestBody EvaluacionGuardar evaluacionGuardar) {
        EvaluacionSalida evaluacion = evaluacionService.crear(evaluacionGuardar);
        if (evaluacion != null) {
            return ResponseEntity.ok(evaluacion);
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionSalida> editar(@PathVariable Integer id, @RequestBody EvaluacionModificar evaluacionModificar) {
        EvaluacionSalida evaluacion = evaluacionService.editar(evaluacionModificar);
        return ResponseEntity.ok(evaluacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        evaluacionService.eliminarPorId(id);
        return ResponseEntity.ok("Evaluación eliminada correctamente");
    }
}
