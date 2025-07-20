package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
// repository/TrabajoRepository.java
import Grupo12.ConectaEmpleo.Model.Trabajo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {
    List<Trabajo> findByCategoriaContainingIgnoreCase(String categoria);
    List<Trabajo> findByUbicacionContainingIgnoreCase(String ubicacion);
}
