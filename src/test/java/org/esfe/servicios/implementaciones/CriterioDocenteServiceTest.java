package org.esfe.servicios.implementaciones;

import org.esfe.dtos.criterio.CriterioGuardar;
import org.esfe.dtos.criterio.CriterioModificar;
import org.esfe.dtos.criterio.CriterioSalida;
import org.esfe.dtos.criterioDocente.CriterioDocenteGuardar;
import org.esfe.dtos.criterioDocente.CriterioDocenteModificar;
import org.esfe.dtos.criterioDocente.CriterioDocenteSalida;
import org.esfe.servicios.interfaces.IAlumnoService;
import org.esfe.servicios.interfaces.ICriterioDocenteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class CriterioDocenteServiceTest {

    @Autowired
    private ICriterioDocenteService criterioDocenteService;


    @Test
    void crear() {

            CriterioDocenteSalida salida = criterioDocenteService.crear(new CriterioDocenteGuardar("registro academico", 3));
        assertNotEquals(null, salida);


        }

    @Test
    void obtenerTodos() {
        int actual = criterioDocenteService.obtenerTodos().size();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerTodosPaginados() {
        int actual = criterioDocenteService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);

    }

    @Test
    void obtenerPorId() {
        CriterioDocenteSalida salida = criterioDocenteService.obtenerPorId(1);
        assertNotEquals(null, salida);

    }



    @Test
    void editar() {
        CriterioDocenteSalida salida = criterioDocenteService.editar(new CriterioDocenteModificar(1, "Registro Rcademico", 3));
        assertNotEquals(null, salida);

    }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                criterioDocenteService.eliminarPorId(3);
            }
        });
    }
}