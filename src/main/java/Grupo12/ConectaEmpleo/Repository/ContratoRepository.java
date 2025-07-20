package Grupo12.ConectaEmpleo.Repository;

import Grupo12.ConectaEmpleo.Model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para operaciones CRUD con la entidad Contrato.
 */
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    public Contrato findByPostulacion_Id(Long postulacionId);
}