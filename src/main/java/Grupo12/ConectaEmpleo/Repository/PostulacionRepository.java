package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {
    boolean existsByTrabajadorAndTrabajo(Usuario trabajador, Trabajo trabajo);
    List<Postulacion> findByTrabajador(Usuario trabajador);
}

