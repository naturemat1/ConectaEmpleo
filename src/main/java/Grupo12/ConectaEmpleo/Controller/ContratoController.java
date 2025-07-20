package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Service.ContratoService;
import Grupo12.ConectaEmpleo.Service.PostulacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador que maneja la aceptación de postulaciones y la creación de contratos.
 */
@Controller
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @Autowired
    private PostulacionService postulacionService;

    /**
     * Acepta una postulación y crea un contrato asociado.
     *
     * @param id ID de la postulación
     * @param session Sesión HTTP
     * @param redirectAttrs Atributos para mensajes flash
     * @return Redirige al perfil del usuario
     */
    @PostMapping("/trabajo/{id}/aceptar")
    public String aceptarPostulacion(
            @PathVariable Long id,
            HttpSession session,
            RedirectAttributes redirectAttrs) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        try {
            // Aceptar postulación
            Postulacion postulacion = postulacionService.aceptarPostulacion(id);

            // Crear contrato asociado
            contratoService.crearContrato(postulacion);

            redirectAttrs.addFlashAttribute("mensaje", "Postulación aceptada y contrato creado.");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/usuario/perfil";
    }
}