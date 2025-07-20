package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.EstadoPostulacion;
import Grupo12.ConectaEmpleo.Model.EstadoTrabajo;
import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Repository.PostulacionRepository;
import Grupo12.ConectaEmpleo.Repository.TrabajoRepository;
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

    @Autowired
    private TrabajoRepository trabajoRepo;

    public void postularse(Usuario trabajador, Trabajo trabajo) {
        if (postulacionRepo.existsByTrabajadorAndTrabajo(trabajador, trabajo)) {
            return;
        }

        Postulacion postulacion = new Postulacion();
        postulacion.setTrabajador(trabajador);
        postulacion.setTrabajo(trabajo);
        postulacion.setEstado(EstadoPostulacion.PENDIENTE);
        postulacionRepo.save(postulacion);
    }

    public List<Postulacion> findByTrabajador(Usuario trabajador) {
        List<Postulacion> postulaciones = postulacionRepo.findByTrabajador(trabajador);

        if (postulaciones.isEmpty()) {
            throw new RuntimeException("No hay postulaciones para el usuario: " + trabajador.getNombre());
        }

        return postulaciones;
    }

    // Método para aceptar una postulación
    public Postulacion aceptarPostulacion(Long id) {
        Postulacion postulacion = postulacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulación no encontrada"));

        if (!"PENDIENTE".equals(postulacion.getEstado().name())) {
            throw new RuntimeException("La postulación ya fue procesada");
        }

        // Cambiar estado de la postulación
        postulacion.setEstado(EstadoPostulacion.ACEPTADO);

        // Obtener el trabajo asociado a la postulación
        Trabajo trabajo = postulacion.getTrabajo();

        if (trabajo != null) {
            trabajo.setEstado(EstadoTrabajo.ACTIVO);
            trabajoRepo.save(trabajo);
        }

        return postulacionRepo.save(postulacion);
    }
}