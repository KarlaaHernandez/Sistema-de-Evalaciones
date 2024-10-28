package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.dtos.docente.DocenteGuardar;
import org.esfe.dtos.docente.DocenteModificar;
import org.esfe.dtos.docente.DocenteSalida;
import org.esfe.servicios.interfaces.ICriterioService;
import org.esfe.servicios.interfaces.IDocenteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.print.Doc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DocenteServiceTest {

    @Autowired
    private IDocenteService docenteService;


    @Test
    void crear() {
        DocenteSalida salida = docenteService.crear(new DocenteGuardar("Cesar Tula", 61713508, "TIDS", "JCTUL@gmil.com", "G4"));
        assertNotEquals(null, salida);

    }

    @Test
    void obtenerTodos() {
        int actual = docenteService.obtenerTodos().size();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerTodosPaginados() {
        int actual = docenteService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerPorId() {
        DocenteSalida salida = docenteService.obtenerPorId(3);
        assertNotEquals(null, salida);

    }



    @Test
    void editar() {
        DocenteSalida salida = docenteService.editar(new DocenteModificar(1,"Cesar Tula", 61713508, "TIDS", "JCTUL@gmil.com", "G4"));
        assertNotEquals(null, salida);

    }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                docenteService.eliminarPorId(1);
            }
        });
    }
}