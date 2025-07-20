package Grupo12.ConectaEmpleo.Controller;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Service.TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trabajo")
public class TrabajoController {

    @Autowired
    private TrabajoService trabajoService;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("trabajo", new Trabajo());
        return "formulario-trabajo";
    }

    @PostMapping("/crear")
    public String crearTrabajo(@ModelAttribute Trabajo trabajo) {
        trabajoService.guardarTrabajo(trabajo); // Aquí luego puedes asociar al usuario autenticado
        return "redirect:/trabajo"; // redirecciona a lista de empleos
    }

    @GetMapping
    public String listarTrabajos(Model model) {
        model.addAttribute("trabajos", trabajoService.listarTodos());
        return "lista-trabajos";
    }
}
