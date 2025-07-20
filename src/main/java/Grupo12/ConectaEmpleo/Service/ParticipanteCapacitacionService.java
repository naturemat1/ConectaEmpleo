package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.*;
import Grupo12.ConectaEmpleo.Repository.ParticipanteCapacitacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteCapacitacionService {

    @Autowired
    private ParticipanteCapacitacionRepository repository;

    public void inscribirUsuarioEnCapacitacion(Usuario usuario, Capacitacion capacitacion) {
        ParticipanteCapacitacionId id = new ParticipanteCapacitacionId();
        id.setUsuarioId(usuario.getId());
        id.setCapacitacionId(capacitacion.getId());

        if (repository.existsById(id)) {
            return;
        }

        ParticipanteCapacitacion pc = new ParticipanteCapacitacion();
        pc.setId(id);
        pc.setUsuario(usuario);
        pc.setCapacitacion(capacitacion);
        pc.setCertificado(false);
        pc.setCalificacionAlumno(null);

        repository.save(pc);
    }

    public List<ParticipanteCapacitacion> findByTrabajador(Usuario trabajador) {
        List<ParticipanteCapacitacion> inscripciones = repository.findByUsuario(trabajador);

        if (inscripciones.isEmpty()) {
            throw new RuntimeException("No hay inscripciones para el usuario: " + trabajador.getNombre());
        }

        return inscripciones;
    }
}
