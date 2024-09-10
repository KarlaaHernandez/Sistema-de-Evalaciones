package org.esfe.controladores;

import org.esfe.dtos.alumno.AlumnoGuardar;
import org.esfe.dtos.alumno.AlumnoModificar;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.dtos.servicio.ServicioGuardar;
import org.esfe.dtos.servicio.ServicioModificar;
import org.esfe.dtos.servicio.ServicioSalida;
import org.esfe.servicios.implementaciones.ServicioService;
import org.esfe.servicios.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public ResponseEntity<Page<ServicioSalida>> mostrarTodoPaginados(Pageable pageable){
        Page<ServicioSalida> servicios = servicioService.obtenerTodosPaginados(pageable);
        if(servicios.hasContent()) {
            return ResponseEntity.ok(servicios);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ServicioSalida>> mostrarTodos(){
        List<ServicioSalida> servicios = servicioService.obtenerTodos();
        if (!servicios.isEmpty()){
            return ResponseEntity.ok(servicios);
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<ServicioSalida> mostrarPorId(@PathVariable Integer id){
        ServicioSalida servicio = servicioService.obtenerPorId(id);
        if(servicio != null){
            return ResponseEntity.ok(servicio);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<ServicioSalida> crear(@RequestBody ServicioGuardar servicioGuardar){
        ServicioSalida servicio = servicioService.crear(servicioGuardar);
        if (servicio != null){
            return ResponseEntity.ok(servicio);

        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioSalida> editar(@PathVariable Integer id, @RequestBody ServicioModificar servicioModificar){
        ServicioSalida servicio = servicioService.editar(servicioModificar);
        if(servicio != null){
            return ResponseEntity.ok(servicio);
        }
        return ResponseEntity.internalServerError().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        servicioService.eliminarPorId(id);
        return ResponseEntity.ok("Servicio eliminado correctamente");
    }

}