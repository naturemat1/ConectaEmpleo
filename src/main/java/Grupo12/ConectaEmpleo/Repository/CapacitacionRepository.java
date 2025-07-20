package Grupo12.ConectaEmpleo.Repository;

import Grupo12.ConectaEmpleo.Model.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para operaciones CRUD con la entidad Capacitacion.
 */
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Long> {
}