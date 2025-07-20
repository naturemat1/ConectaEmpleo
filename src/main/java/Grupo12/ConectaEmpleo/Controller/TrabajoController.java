package Grupo12.ConectaEmpleo.Controller;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.EstadoTrabajo;
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Service.TrabajoService;
import Grupo12.ConectaEmpleo.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/trabajo")
public class TrabajoController {

    @Autowired
    private TrabajoService trabajoService;
    @Autowired
    private UsuarioService usuarioService;

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

    @GetMapping("/personalizado")
    public String listarTrabajosPersonalizados(Model model,
            @RequestParam(name = "categoria", required = false) String categoria,
            @RequestParam(name = "ubicacion", required = false) String ubicacion) {

        List<Trabajo> trabajos = trabajoService.buscarPorCategoriaOUbicacion(categoria, ubicacion);
        model.addAttribute("trabajos", trabajos);

        return "lista-trabajos";
    }

    @PostMapping("/{id}/finalizar")
    public String finalizarTrabajo(
            @PathVariable Long id,
            HttpSession session,
            RedirectAttributes redirectAttrs) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        Trabajo trabajo = trabajoService.obtenerPorId(id);
        if (trabajo == null) {
            redirectAttrs.addFlashAttribute("error", "Trabajo no encontrado.");
            return "redirect:/usuario/perfil";
        }

        // Marcar el trabajo como finalizado
        trabajo.setEstado(EstadoTrabajo.FINALIZADO);
        trabajoService.guardarTrabajo(trabajo);

        // Pasar el ID del trabajo al formulario de calificación
        redirectAttrs.addFlashAttribute("trabajoId", id);

        return "redirect:/trabajo/calificar";
    }

    @GetMapping("/calificar")
    public String mostrarFormularioCalificacion(Model model) {
        // Obtenemos el trabajoId desde el modelo
        Long trabajoId = (Long) model.getAttribute("trabajoId");

        if (trabajoId == null) {
            return "redirect:/usuario/perfil";
        }

        model.addAttribute("trabajoId", trabajoId);
        return "calificar";
    }

    @PostMapping("/calificar")
    public String calificarTrabajo(
            @RequestParam Long trabajoId,
            @RequestParam Integer puntuacion,
            @RequestParam(required = false) String comentario,
            HttpSession session,
            RedirectAttributes redirectAttrs) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        Trabajo trabajo = trabajoService.obtenerPorId(trabajoId);
        if (trabajo == null) {
            redirectAttrs.addFlashAttribute("error", "Trabajo no encontrado.");
            return "redirect:/usuario/perfil";
        }

        // Califica al trabajador
        Usuario trabajador = trabajo.getSolicitante();
        if (trabajador != null) {
            usuarioService.actualizarCalificacionPromedio(trabajador, puntuacion);
        } else {
            redirectAttrs.addFlashAttribute("error", "No se encontró al trabajador.");
            return "redirect:/usuario/perfil";
        }

        // Elimina el trabajo
        trabajoService.eliminar(trabajo);

        redirectAttrs.addFlashAttribute("mensaje", "Gracias por tu calificación.");
        return "redirect:/trabajo";
    }
}
