package org.esfe.controladores;
import org.esfe.dtos.detalleDocente.DetalleDocenteGuardar;
import org.esfe.dtos.detalleDocente.DetalleDocenteModificar;
import org.esfe.dtos.detalleDocente.DetalleDocenteSalida;
import org.esfe.servicios.interfaces.IDetalleDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/detallesDocente")
public class DetalleDocenteController {
    @Autowired
    private IDetalleDocenteService detalleDocenteService;

    @GetMapping
    public ResponseEntity<Page<DetalleDocenteSalida>> mostrarTodoPaginados(Pageable pageable){
        Page<DetalleDocenteSalida> detallesDocente = detalleDocenteService.obtenerTodosPaginados(pageable);
        if(detallesDocente.hasContent()) {
            return ResponseEntity.ok(detallesDocente);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<DetalleDocenteSalida>> mostrarTodos() {
        List<DetalleDocenteSalida> detallesDocente = detalleDocenteService.obtenerTodos();
        if(!detallesDocente.isEmpty()) {
            return ResponseEntity.ok(detallesDocente);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleDocenteSalida> buscarPorId(@PathVariable Integer id){
        DetalleDocenteSalida detalleDocente = detalleDocenteService.obtenerPorId(id);
        if(detalleDocente != null){
            return ResponseEntity.ok(detalleDocente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DetalleDocenteSalida> crear(@RequestBody DetalleDocenteGuardar detalleDocenteGuardar){
        DetalleDocenteSalida detalleDocente = detalleDocenteService.crear(detalleDocenteGuardar);
        return ResponseEntity.ok(detalleDocente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleDocenteSalida> editar(@PathVariable Integer id, @RequestBody DetalleDocenteModificar detalleDocenteModificar){
        DetalleDocenteSalida detalleDocente = detalleDocenteService.editar(detalleDocenteModificar);
        return ResponseEntity.ok(detalleDocente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        detalleDocenteService.eliminarPorId(id);
        return ResponseEntity.ok("DetalleDocente eliminado correctamente");
    }
}
