package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Model.Capacitacion;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Service.CapacitacionService;
import Grupo12.ConectaEmpleo.Service.ParticipanteCapacitacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParticipanteCapacitacionController {

    @Autowired
    private ParticipanteCapacitacionService participanteService;
    @Autowired
    private CapacitacionService capacitacionService;

    @PostMapping("/capacitaciones/{id}/inscribirse")
    public String inscribirse(@PathVariable Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        Capacitacion capacitacion = capacitacionService.obtenerPorId(id);
        participanteService.inscribirUsuarioEnCapacitacion(usuario, capacitacion);

        return "redirect:/capacitaciones";
    }
}
