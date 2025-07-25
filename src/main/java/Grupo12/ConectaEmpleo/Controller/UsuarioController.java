package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Model.ParticipanteCapacitacion;
import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Service.UsuarioService;
import Grupo12.ConectaEmpleo.Service.PostulacionService;
import Grupo12.ConectaEmpleo.Service.ParticipanteCapacitacionService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostulacionService postulacionService;

    @Autowired
    private ParticipanteCapacitacionService inscripcionService;

    /**
     * Muestra el formulario de registro de usuario.
     *
     * @param model Modelo para pasar atributos a la vista
     * @return Nombre de la vista "registro"
     */
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    /**
     * Registra un nuevo usuario.
     *
     * @param usuario Usuario a registrar
     * @param model Modelo para pasar mensajes de éxito/error
     * @return Redirige al inicio si es exitoso, o muestra el formulario si hay error
     */
    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        if (usuarioService.correoExiste(usuario.getCorreo())) {
            model.addAttribute("error", "El correo ya está registrado");
            return "registro";
        }

        usuarioService.registrar(usuario);
        model.addAttribute("mensaje", "Registro exitoso");
        return "redirect:/"; // Redirige al index
    }

    /**
     * Muestra la vista de login.
     *
     * @return Nombre de la vista "login"
     */
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    /**
     * Procesa el login del usuario.
     *
     * @param correo Correo del usuario
     * @param contrasena Contraseña del usuario
     * @param model Modelo para pasar mensajes de error
     * @param session Sesión HTTP para guardar al usuario logueado
     * @return Redirige al inicio si es válido, o muestra el formulario de login si no lo es
     */
    @PostMapping("/login")
    public String loginUsuario(
            @RequestParam String correo,
            @RequestParam String contrasena,
            Model model,
            HttpSession session) {

        Usuario usuario = usuarioService.autenticar(correo, contrasena);
        if (usuario != null) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }
    }

    /**
     * Muestra el perfil del usuario logueado.
     *
     * @param session Sesión HTTP
     * @param model Modelo para pasar datos a la vista
     * @return Nombre de la vista "perfil" o redirección al login si no hay sesión
     */
    @GetMapping("/perfil")
    public String mostrarPerfil(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        List<Postulacion> postulaciones = postulacionService.findByTrabajador(usuario);
        List<ParticipanteCapacitacion> inscripciones = inscripcionService.findByTrabajador(usuario);

        model.addAttribute("postulaciones", postulaciones);
        model.addAttribute("inscripciones", inscripciones);

        return "perfil";
    }
}