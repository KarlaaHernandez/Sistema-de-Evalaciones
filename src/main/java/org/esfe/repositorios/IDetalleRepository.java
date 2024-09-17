package org.esfe.repositorios;

import org.esfe.modelos.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleRepository extends JpaRepository<Detalle, Integer> {
}
