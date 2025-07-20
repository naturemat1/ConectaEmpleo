package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
// repository/TrabajoRepository.java
import Grupo12.ConectaEmpleo.Model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {
    // puedes agregar métodos personalizados luego
}
