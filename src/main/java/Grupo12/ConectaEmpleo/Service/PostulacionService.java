package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.EstadoPostulacion;
import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Repository.PostulacionRepository;
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
        if (postulacionRepo.existsByTrabajadorAndTrabajo(trabajador, trabajo)) return;

        Postulacion postulacion = new Postulacion();
        postulacion.setTrabajador(trabajador);
        postulacion.setTrabajo(trabajo);
        postulacion.setEstado(EstadoPostulacion.PENDIENTE); // Enum, asumiendo que lo tienes
        postulacionRepo.save(postulacion);
    }
}

