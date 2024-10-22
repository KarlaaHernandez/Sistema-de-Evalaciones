package org.esfe.repositorios;


import org.esfe.modelos.EvaluacionDocente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvaluacionDocenteRepository extends JpaRepository<EvaluacionDocente, Integer> {
}
