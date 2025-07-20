package Grupo12.ConectaEmpleo.Service;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Repository.TrabajoRepository;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<Trabajo> buscarPorCategoriaOUbicacion(String categoria, String ubicacion) {
        if (categoria != null && !categoria.isEmpty()) {
            return trabajoRepository.findByCategoriaContainingIgnoreCase(categoria);
        } else if (ubicacion != null && !ubicacion.isEmpty()) {
            return trabajoRepository.findByUbicacionContainingIgnoreCase(ubicacion);
        } else {
            return trabajoRepository.findAll();
        }
    }

    public Map<String, Long> obtenerCategoriasConMasOfertas() {
        List<Trabajo> trabajos = trabajoRepository.findAll();
        Map<String, Long> categoriasConteo = new HashMap<>();

        for (Trabajo t : trabajos) {
            String categoria = t.getCategoria();
            if (categoria != null && !categoria.trim().isEmpty()) {
                categoriasConteo.put(categoria, categoriasConteo.getOrDefault(categoria, 0L) + 1);
            }
        }
        return categoriasConteo;
    }

    public void eliminar(Trabajo trabajo) {
        trabajoRepository.delete(trabajo);
    }

}
