package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private TrabajoRepository trabajoRepo;

    @Autowired
    private PostulacionRepository postulacionRepo;

    @Autowired
    private CapacitacionRepository capacitacionRepo;

    @Autowired
    private ParticipanteCapacitacionRepository inscripcionRepo;

    @GetMapping("/reportes")
    public String verReportes(Model model) {
        // Obtener las métricas
        long usuarios = usuarioRepo.count();
        long trabajos = trabajoRepo.count();
        long postulaciones = postulacionRepo.count();
        long capacitaciones = capacitacionRepo.count();
        long inscripciones = inscripcionRepo.count();

        // Enviar al HTML
        model.addAttribute("usuariosCount", usuarios);
        model.addAttribute("trabajosCount", trabajos);
        model.addAttribute("postulacionesCount", postulaciones);
        model.addAttribute("capacitacionesCount", capacitaciones);
        model.addAttribute("inscripcionesCount", inscripciones);

        long max = Math.max(
                Math.max(Math.max(usuarios, trabajos), postulaciones),
                Math.max(capacitaciones, inscripciones)
        );

        model.addAttribute("maxValor", max);

        return "reportes";
    }

}
