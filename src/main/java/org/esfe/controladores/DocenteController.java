package org.esfe.controladores;


import org.esfe.dtos.docente.DocenteGuardar;
import org.esfe.dtos.docente.DocenteModificar;
import org.esfe.dtos.docente.DocenteSalida;
import org.esfe.servicios.interfaces.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private IDocenteService docenteService;


    @GetMapping
    public ResponseEntity<Page<DocenteSalida>> mostrarTodoPaginados(Pageable pageable){
        Page<DocenteSalida> docentes = docenteService.obtenerTodosPaginados(pageable);
        if(docentes.hasContent()) {
            return ResponseEntity.ok(docentes);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<DocenteSalida>> mostrarTodos() {
        List<DocenteSalida> docentes = docenteService.obtenerTodos();
        if(!docentes.isEmpty()) {
            return ResponseEntity.ok(docentes);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteSalida> buscarPorId(@PathVariable Integer id){
        DocenteSalida docente = docenteService.obtenerPorId(id);
        if(docente != null){
            return ResponseEntity.ok(docente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DocenteSalida> crear(@RequestBody DocenteGuardar docenteGuardar){
        DocenteSalida docente = docenteService.crear(docenteGuardar);
        return ResponseEntity.ok(docente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteSalida> editar(@PathVariable Integer id, @RequestBody DocenteModificar docenteModificar){
        DocenteSalida docente = docenteService.editar(docenteModificar);
        return ResponseEntity.ok(docente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        docenteService.eliminarPorId(id);
        return ResponseEntity.ok("Docente eliminado correctamente");
    }


}
