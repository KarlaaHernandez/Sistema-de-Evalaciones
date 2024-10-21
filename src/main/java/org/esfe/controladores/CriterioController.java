package org.esfe.controladores;

import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.servicios.interfaces.ICriterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criterios")
public class CriterioController {

    @Autowired
    private ICriterioService criterioService;

    @GetMapping
    public ResponseEntity<Page<CriterioSalida>> mostrarTodoPaginados(Pageable pageable){
        Page<CriterioSalida> criterios = criterioService.obtenerTodosPaginados(pageable);
        if(criterios.hasContent()) {
            return ResponseEntity.ok(criterios);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<CriterioSalida>> mostrarTodos() {
        List<CriterioSalida> criterios = criterioService.obtenerTodos();
        if(!criterios.isEmpty()) {
            return ResponseEntity.ok(criterios);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriterioSalida> buscarPorId(@PathVariable Integer id){
        CriterioSalida criterio = criterioService.obtenerPorId(id);
        if(criterio != null){
            return ResponseEntity.ok(criterio);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CriterioSalida> crear(@RequestBody CriterioGuardar criterioGuardar){
        CriterioSalida criterio = criterioService.crear(criterioGuardar);
        return ResponseEntity.ok(criterio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriterioSalida> editar(@PathVariable Integer id, @RequestBody CriterioModificar criterioModificar){
        CriterioSalida criterio = criterioService.editar(criterioModificar);
        if(criterio != null){
            return ResponseEntity.ok(criterio);
        }

        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        criterioService.eliminarPorId(id);
        return ResponseEntity.ok("criterio eliminado correctamente");
    }
}
