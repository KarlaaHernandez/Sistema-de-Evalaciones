package org.esfe.repositorios;

import org.esfe.modelos.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvaluacionRepository extends JpaRepository<Evaluacion, Integer> {
}
