package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para la página de inicio del sistema. Muestra estadísticas como
 * la categoría más demandada.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * Carga la página de inicio y pasa la categoría más demandada al modelo.
     *
     * @param model Modelo para pasar atributos a la vista
     * @return Nombre de la vista "index"
     */
    @GetMapping("/")
    public String index(Model model) {
        String categoriaMasDemandada = indexService.obtenerCategoriaMasDemandada();
        model.addAttribute("categoriaMasDemandada", categoriaMasDemandada);
        return "index";
    }
}
