package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
// repository/ParticipanteCapacitacionRepository.java
import Grupo12.ConectaEmpleo.Model.ParticipanteCapacitacion;
import Grupo12.ConectaEmpleo.Model.ParticipanteCapacitacionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteCapacitacionRepository extends JpaRepository<ParticipanteCapacitacion, ParticipanteCapacitacionId> {
    boolean existsById(ParticipanteCapacitacionId id);
}
