package Grupo12.ConectaEmpleo.Controller;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Capacitacion;
import Grupo12.ConectaEmpleo.Service.CapacitacionService;
import Grupo12.ConectaEmpleo.Service.TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;
    @Autowired
    private TrabajoService trabajoService;

    @GetMapping
    public String mostrarCapacitaciones(Model model) {
        model.addAttribute("capacitaciones", capacitacionService.obtenerTodas());
        return "lista-capacitaciones";
    }
    
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("capacitacion", new Capacitacion());
        return "formulario-capacitacion";
    }

    @PostMapping("/crear")
    public String crearCapacitacion(@ModelAttribute Capacitacion capacitacion) {
        capacitacionService.guardar(capacitacion); // Aquí también puedes vincular con el capacitador
        return "redirect:/capacitaciones";
    }
    
}
