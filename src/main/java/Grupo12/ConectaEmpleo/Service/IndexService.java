package Grupo12.ConectaEmpleo.Service;

import java.util.Map;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    private TrabajoService trabajoService;

    /**
     * Obtiene la categoría con más ofertas publicadas.
     *
     * @return Categoría más demandada
     */
    public String obtenerCategoriaMasDemandada() {
        Map<String, Long> categoriasConOfertas = trabajoService.obtenerCategoriasConMasOfertas();

        if (categoriasConOfertas.isEmpty()) {
            return null;
        }

        return Collections.max(categoriasConOfertas.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
