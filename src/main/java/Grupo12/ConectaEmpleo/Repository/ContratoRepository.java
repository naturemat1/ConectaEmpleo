package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    public Contrato findByPostulacion_Id(Long postulacionId);
}

