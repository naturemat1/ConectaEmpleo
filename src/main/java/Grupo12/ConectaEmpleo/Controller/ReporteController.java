package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador encargado de gestionar las solicitudes relacionadas con los reportes de impacto del sistema.
 * <p>
 * Este controlador se encarga de recopilar métricas clave del sistema (como cantidad de usuarios, trabajos,
 * postulaciones, capacitaciones e inscripciones) y enviarlas a la vista correspondiente para su visualización.
 * Es utilizado principalmente para mostrar estadísticas generales en una página de reportes.
 * </p>
 *
 * @author Grupo12
 * @version 1.0
 * @since 2025
 */
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

    /**
     * Maneja las solicitudes GET a la ruta "/reportes".
     * <p>
     * Este método consulta las cantidades totales de registros en las principales entidades del sistema
     * mediante sus respectivos repositorios. Luego, calcula el valor máximo entre todas estas métricas
     * para normalizar visualmente las barras en la interfaz (por ejemplo, en gráficos de progreso).
     * Finalmente, añade todos los datos al modelo para que sean accesibles en la plantilla Thymeleaf.
     * </p>
     *
     * @param model El objeto {@link Model} utilizado para pasar atributos a la vista.
     * @return El nombre de la vista Thymeleaf a renderizar ("reportes").
     */
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