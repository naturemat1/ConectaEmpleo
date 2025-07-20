package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.*;
import Grupo12.ConectaEmpleo.Repository.ParticipanteCapacitacionRepository;
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

        if (repository.existsById(id)) return;

        ParticipanteCapacitacion pc = new ParticipanteCapacitacion();
        pc.setId(id);
        pc.setUsuario(usuario);
        pc.setCapacitacion(capacitacion);
        pc.setCertificado(false);
        pc.setCalificacionAlumno(null);

        repository.save(pc);
    }
}

