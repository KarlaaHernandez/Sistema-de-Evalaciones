package org.esfe.servicios.implementaciones;

import org.esfe.dtos.alumno.AlumnoGuardar;
import org.esfe.dtos.alumno.AlumnoModificar;
import org.esfe.dtos.alumno.AlumnoSalida;
import org.esfe.servicios.interfaces.IAlumnoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AlumnoServiceTest {

 @Autowired
    private IAlumnoService alumnoService;

   @Test
   void crear() {
      AlumnoSalida salida = alumnoService.crear(new AlumnoGuardar("Prueba", "Prueba", "Prueba", "Prueba"));
      assertNotEquals(null, salida);
   }

    @Test
    void obtenerTodos() {
        int actual = alumnoService.obtenerTodos().size();
        assertNotEquals(0, actual);
    }

    @Test
    void obtenerTodosPaginados() {
       int actual = alumnoService.obtenerTodosPaginados(PageRequest.of(0, 10)).getSize();
       assertNotEquals(0, actual);
    }

    @Test
    void obtenerPorId() {
       AlumnoSalida salida = alumnoService.obtenerPorId(1);
       assertNotEquals(null, salida);
    }



    @Test
    void editar() {
       AlumnoSalida salida = alumnoService.editar(new AlumnoModificar(1, "Prueba Modificar", "Prueba Modificar", "Prueba Modificar","Prueba Modificar")
       );
       assertNotEquals(null, salida);
    }

    @Test
    void eliminarPorId() {
       assertDoesNotThrow(new Executable() {
          @Override
          public void execute() throws Throwable {
             alumnoService.eliminarPorId(2);
          }
       });
    }
}