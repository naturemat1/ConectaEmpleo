package Grupo12.ConectaEmpleo.Service;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Capacitacion;
import Grupo12.ConectaEmpleo.Repository.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapacitacionService {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    public List<Capacitacion> obtenerTodas() {
        return capacitacionRepository.findAll();
    }
    
    public void guardar(Capacitacion capacitacion) {
        capacitacionRepository.save(capacitacion);
    }
    
    public Capacitacion obtenerPorId(Long id) {
        Capacitacion capacitacion = null;

        // Llamamos al método personalizado del repositorio para buscar por código de usuario
        Optional<Capacitacion> optional = capacitacionRepository.findById(id);

        if (optional.isPresent()) {
            // Si el usuario existe, lo obtenemos del Optional
            capacitacion = optional.get();
        } else {
            // Si no se encuentra, lanzamos una excepción
            throw new RuntimeException("No existe la capacitacion: " + id);
        }

        return capacitacion;
    }
}

