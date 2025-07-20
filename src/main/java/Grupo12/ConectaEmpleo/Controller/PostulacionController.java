package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Service.PostulacionService;
import Grupo12.ConectaEmpleo.Service.TrabajoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Home
 */
@Controller
public class PostulacionController {

    @Autowired
    private PostulacionService postulacionService;

    @Autowired
    private TrabajoService trabajoService;

    @PostMapping("/empleos/{id}/postular")
    public String postular(@PathVariable Long id, HttpSession session) {
        System.out.println("ENTRAMOS AL CONTROLADOR DE POSTULACIÓN");

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            System.out.println("USUARIO NO AUTENTICADO");
            return "redirect:/usuario/login";
        }

        System.out.println("USUARIO LOGUEADO: " + usuario.getNombre());
        System.out.println("ID DEL TRABAJO: " + id);

        Trabajo trabajo = trabajoService.obtenerPorId(id);
        postulacionService.postularse(usuario, trabajo);

        return "redirect:/trabajo";
    }
}
