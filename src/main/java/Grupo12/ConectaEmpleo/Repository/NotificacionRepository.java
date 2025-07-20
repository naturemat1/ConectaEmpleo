package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    
}

