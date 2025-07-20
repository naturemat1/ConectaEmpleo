package Grupo12.ConectaEmpleo.Repository;

import Grupo12.ConectaEmpleo.Model.Trabajo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para operaciones CRUD con la entidad Trabajo.
 */
public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {
    List<Trabajo> findByCategoriaContainingIgnoreCase(String categoria);
    List<Trabajo> findByUbicacionContainingIgnoreCase(String ubicacion);
}