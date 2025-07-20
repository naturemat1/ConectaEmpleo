package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Service.TrabajoService;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Home
 */
@Controller
public class IndexController {

    @Autowired
    private TrabajoService trabajoService;

    @GetMapping("/")
    public String index(Model model) {
        Map<String, Long> categoriasConOfertas = trabajoService.obtenerCategoriasConMasOfertas();

        System.out.println("CATEGORÍAS CON OFERTAS:");
        for (Map.Entry<String, Long> entry : categoriasConOfertas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String categoriaMasDemandada = null;
        if (!categoriasConOfertas.isEmpty()) {
            categoriaMasDemandada = Collections.max(categoriasConOfertas.entrySet(),
                    Map.Entry.comparingByValue()).getKey();
        }

        System.out.println("CATEGORÍA MÁS DEMANDADA: " + categoriaMasDemandada);

        model.addAttribute("categoriaMasDemandada", categoriaMasDemandada);
        return "index";
    }
}
