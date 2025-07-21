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
 * Servicio que maneja la lógica del negocio relacionada con las postulaciones:
 * - Postularse a un trabajo
 * - Aceptar o rechazar una postulación
 * - Validar existencia de postulaciones
 */
@Service
public class PostulacionService {

    @Autowired
    private PostulacionRepository postulacionRepo;

    @Autowired
    private TrabajoRepository trabajoRepo;

    /**
     * Permite a un usuario postularse a un trabajo.
     *
     * @param trabajador Usuario que postula
     * @param trabajo Trabajo al que se postula
     */
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

    /**
     * Obtiene todas las postulaciones de un usuario.
     *
     * @param trabajador Usuario al que se le buscan las postulaciones
     * @return Lista de postulaciones del usuario
     */
    public List<Postulacion> findByTrabajador(Usuario trabajador) {
        List<Postulacion> postulaciones = postulacionRepo.findByTrabajador(trabajador);

        /*if (postulaciones.isEmpty()) {
            throw new RuntimeException("No hay postulaciones para el usuario: " + trabajador.getNombre());
        }*/

        return postulaciones;
    }

    /**
     * Acepta una postulación y cambia su estado a "ACEPTADO".
     *
     * @param id ID de la postulación
     * @return La postulación aceptada
     */
    public Postulacion aceptarPostulacion(Long id) {
        Postulacion postulacion = postulacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulación no encontrada"));

        if (!"PENDIENTE".equals(postulacion.getEstado().name())) {
            throw new RuntimeException("La postulación ya fue procesada");
        }

        postulacion.setEstado(EstadoPostulacion.ACEPTADO);

        Trabajo trabajo = postulacion.getTrabajo();
        if (trabajo != null) {
            trabajo.setEstado(EstadoTrabajo.ACTIVO);
            trabajoRepo.save(trabajo);
        }

        return postulacionRepo.save(postulacion);
    }
}