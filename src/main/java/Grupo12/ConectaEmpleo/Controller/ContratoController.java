/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo12.ConectaEmpleo.Controller;

import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Service.ContratoService;
import Grupo12.ConectaEmpleo.Service.PostulacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Home
 */
@Controller
public class ContratoController {

    @Autowired
    private ContratoService contratoService;
    @Autowired
    private PostulacionService postulacionService;

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
            // Lógica en el servicio
            Postulacion postulacion = postulacionService.aceptarPostulacion(id);
            contratoService.crearContrato(postulacion);

            redirectAttrs.addFlashAttribute("mensaje", "Postulación aceptada y contrato creado.");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/usuario/perfil";
    }
}
