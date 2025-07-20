package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Repository.TrabajoRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio que maneja la lógica del negocio relacionada con los trabajos: -
 * Crear, listar, buscar por categoría o ubicación - Actualizar estado -
 * Eliminar
 */
@Service
public class TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepo;

    /**
     * Guarda un trabajo en la base de datos.
     *
     * @param trabajo Trabajo a guardar
     */
    public void guardarTrabajo(Trabajo trabajo) {
        trabajoRepo.save(trabajo);
    }

    /**
     * Obtiene todos los trabajos.
     *
     * @return Lista de todos los trabajos
     */
    public List<Trabajo> listarTodos() {
        return trabajoRepo.findAll();
    }

    /**
     * Obtiene un trabajo por ID.
     *
     * @param id ID del trabajo
     * @return Trabajo encontrado
     */
    public Trabajo obtenerPorId(Long id) {
        return trabajoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajo no encontrado"));
    }

    /**
     * Busca trabajos por categoría o ubicación.
     *
     * @param categoria Categoría del trabajo
     * @param ubicacion Ubicación del trabajo
     * @return Lista de trabajos filtrados
     */
    public List<Trabajo> buscarPorCategoriaOUbicacion(String categoria, String ubicacion) {
        if (categoria != null && !categoria.isEmpty()) {
            return trabajoRepo.findByCategoriaContainingIgnoreCase(categoria);
        } else if (ubicacion != null && !ubicacion.isEmpty()) {
            return trabajoRepo.findByUbicacionContainingIgnoreCase(ubicacion);
        } else {
            return trabajoRepo.findAll();
        }
    }

    /**
     * Obtiene una lista de categorías con más ofertas.
     *
     * @return Mapa con categorías y cantidad de ofertas
     */
    public Map<String, Long> obtenerCategoriasConMasOfertas() {
        List<Trabajo> trabajos = trabajoRepo.findAll();
        Map<String, Long> categoriasConteo = new HashMap<>();

        for (Trabajo t : trabajos) {
            String categoria = t.getCategoria();
            if (categoria != null && !categoria.trim().isEmpty()) {
                categoriasConteo.put(categoria, categoriasConteo.getOrDefault(categoria, 0L) + 1);
            }
        }

        return categoriasConteo;
    }

    /**
     * Elimina un trabajo de la base de datos.
     *
     * @param trabajo Trabajo a eliminar
     */
    public void eliminar(Trabajo trabajo) {
        trabajoRepo.delete(trabajo);
    }
}
