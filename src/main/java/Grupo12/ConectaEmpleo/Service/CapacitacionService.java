package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Capacitacion;
import Grupo12.ConectaEmpleo.Repository.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que maneja la lógica del negocio relacionada con las capacitaciones:
 * - Listar todas las capacitaciones
 * - Guardar una capacitación
 * - Buscar por ID
 */
@Service
public class CapacitacionService {

    @Autowired
    private CapacitacionRepository capacitacionRepo;

    /**
     * Obtiene todas las capacitaciones registradas.
     *
     * @return Lista de todas las capacitaciones
     */
    public List<Capacitacion> obtenerTodas() {
        return capacitacionRepo.findAll();
    }

    /**
     * Guarda una nueva capacitación en la base de datos.
     *
     * @param capacitacion Capacitación a guardar
     */
    public void guardar(Capacitacion capacitacion) {
        capacitacionRepo.save(capacitacion);
    }

    /**
     * Obtiene una capacitación por su ID.
     *
     * @param id ID de la capacitación
     * @return La capacitación encontrada
     */
    public Capacitacion obtenerPorId(Long id) {
        Optional<Capacitacion> optional = capacitacionRepo.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("No existe la capacitación: " + id);
        }
    }
}