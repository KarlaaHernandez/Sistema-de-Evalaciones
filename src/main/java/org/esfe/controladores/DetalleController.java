package org.esfe.controladores;




import org.esfe.dtos.detalle.DetalleGuardar;
import org.esfe.dtos.detalle.DetalleModificar;
import org.esfe.dtos.detalle.DetalleSalida;
import org.esfe.servicios.interfaces.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/detalles")
public class DetalleController {
    @Autowired
    private IDetalleService detalleService;

    @GetMapping
    public ResponseEntity<Page<DetalleSalida>> mostrarTodoPaginados(Pageable pageable){
        Page<DetalleSalida> detalles = detalleService.obtenerTodosPaginados(pageable);
        if(detalles.hasContent()) {
            return ResponseEntity.ok(detalles);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<DetalleSalida>> mostrarTodos() {
        List<DetalleSalida> detalles = detalleService.obtenerTodos();
        if(!detalles.isEmpty()) {
            return ResponseEntity.ok(detalles);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleSalida> buscarPorId(@PathVariable Integer id){
        DetalleSalida detalle = detalleService.obtenerPorId(id);
        if(detalle != null){
            return ResponseEntity.ok(detalle);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DetalleSalida> crear(@RequestBody DetalleGuardar detalleGuardar){
        DetalleSalida detalle = detalleService.crear(detalleGuardar);
        return ResponseEntity.ok(detalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleSalida> editar(@PathVariable Integer id, @RequestBody DetalleModificar detalleModificar){
        DetalleSalida detalle = detalleService.editar(detalleModificar);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        detalleService.eliminarPorId(id);
        return ResponseEntity.ok("Detalle eliminado correctamente");
    }
}
