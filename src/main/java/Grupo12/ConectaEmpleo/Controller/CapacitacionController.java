package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Model.Capacitacion;
import Grupo12.ConectaEmpleo.Service.CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;


    /**
     * Muestra todas las capacitaciones disponibles.
     *
     * @param model Modelo para pasar atributos a la vista
     * @return Nombre de la vista "lista-capacitaciones"
     */
    @GetMapping
    public String mostrarCapacitaciones(Model model) {
        model.addAttribute("capacitaciones", capacitacionService.obtenerTodas());
        return "lista-capacitaciones";
    }

    /**
     * Muestra el formulario para crear una nueva capacitación.
     *
     * @param model Modelo para pasar atributos a la vista
     * @return Nombre de la vista "formulario-capacitacion"
     */
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("capacitacion", new Capacitacion());
        return "formulario-capacitacion";
    }

    /**
     * Crea una nueva capacitación.
     *
     * @param capacitacion Capacitación a crear
     * @return Redirige al listado de capacitaciones
     */
    @PostMapping("/crear")
    public String crearCapacitacion(@ModelAttribute Capacitacion capacitacion) {
        capacitacionService.guardar(capacitacion);
        return "redirect:/capacitaciones";
    }
}