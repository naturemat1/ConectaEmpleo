package Grupo12.ConectaEmpleo.Service;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Contrato;
import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepo;
    

    public void crearContrato(Postulacion postulacion) {
        Contrato contrato = new Contrato();
        contrato.setPostulacion(postulacion);
        contratoRepo.save(contrato);
    }

    public void calificarContrato(Contrato contrato, Integer calificacionTrabajador, Integer calificacionSolicitante, String comentarios) {
        contrato.setCalificacionTrabajador(calificacionTrabajador);
        contrato.setCalificacionSolicitante(calificacionSolicitante);
        contrato.setComentarios(comentarios);
        contratoRepo.save(contrato);
    }

    public Contrato obtenerContratoPorPostulacion(Long postulacionId) {
        return contratoRepo.findByPostulacion_Id(postulacionId);
    }
}
