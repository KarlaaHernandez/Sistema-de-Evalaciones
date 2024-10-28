package org.esfe.repositorios;

import org.esfe.modelos.DetalleDocente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleDocenteRepository extends JpaRepository<DetalleDocente, Integer> {
}
