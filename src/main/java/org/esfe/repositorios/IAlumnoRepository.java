package org.esfe.repositorios;

import org.esfe.modelos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
}
