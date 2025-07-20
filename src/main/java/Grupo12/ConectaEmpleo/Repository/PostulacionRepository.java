package Grupo12.ConectaEmpleo.Repository;

import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Model.Trabajo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para operaciones CRUD con la entidad Postulacion.
 */
public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {
    boolean existsByTrabajadorAndTrabajo(Usuario trabajador, Trabajo trabajo);
    List<Postulacion> findByTrabajador(Usuario trabajador);
}