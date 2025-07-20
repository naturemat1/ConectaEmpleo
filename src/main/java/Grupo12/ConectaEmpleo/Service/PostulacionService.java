package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.EstadoPostulacion;
import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Repository.PostulacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Home
 */
@Service
public class PostulacionService {

    @Autowired
    private PostulacionRepository postulacionRepo;

    public void postularse(Usuario trabajador, Trabajo trabajo) {
        if (postulacionRepo.existsByTrabajadorAndTrabajo(trabajador, trabajo)) {
            return;
        }

        Postulacion postulacion = new Postulacion();
        postulacion.setTrabajador(trabajador);
        postulacion.setTrabajo(trabajo);
        postulacion.setEstado(EstadoPostulacion.PENDIENTE); // Enum, asumiendo que lo tienes
        postulacionRepo.save(postulacion);
    }

    public List<Postulacion> findByTrabajador(Usuario trabajador) {
        List<Postulacion> postulaciones = postulacionRepo.findByTrabajador(trabajador);

        if (postulaciones.isEmpty()) {
            throw new RuntimeException("No hay postulaciones para el usuario: " + trabajador.getNombre());
        }

        return postulaciones;
    }
}
