package Grupo12.ConectaEmpleo.Service;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    public void guardarTrabajo(Trabajo trabajo) {
        trabajoRepository.save(trabajo);
    }

    public List<Trabajo> listarTodos() {
        return trabajoRepository.findAll();
    }
    
    public Trabajo obtenerPorId(Long id) {
        return trabajoRepository.findById(id)
                   .orElseThrow(() -> new RuntimeException("Trabajo no encontrado"));
    }
}

