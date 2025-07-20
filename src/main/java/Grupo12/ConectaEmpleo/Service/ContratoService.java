package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Contrato;
import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Servicio que maneja la lógica del negocio relacionada con los contratos:
 * - Crear contrato tras aceptar una postulación
 * - Calificar al trabajador o al solicitante
 */
@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepo;

    /**
     * Crea un contrato asociado a una postulación.
     *
     * @param postulacion Postulación aceptada
     */
    public void crearContrato(Postulacion postulacion) {
        Contrato contrato = new Contrato();
        contrato.setPostulacion(postulacion);
        contratoRepo.save(contrato);
    }

    /**
     * Califica al trabajador y al solicitante en el contrato.
     *
     * @param contrato Contrato a calificar
     * @param calificacionTrabajador Calificación del solicitante al trabajador
     * @param calificacionSolicitante Calificación del trabajador al solicitante
     * @param comentarios Comentarios del contrato
     */
    public void calificarContrato(Contrato contrato, Integer calificacionTrabajador, Integer calificacionSolicitante, String comentarios) {
        contrato.setCalificacionTrabajador(calificacionTrabajador);
        contrato.setCalificacionSolicitante(calificacionSolicitante);
        contrato.setComentarios(comentarios);
        contratoRepo.save(contrato);
    }

    /**
     * Obtiene un contrato por el ID de la postulación.
     *
     * @param postulacionId ID de la postulación
     * @return Contrato encontrado o null si no existe
     */
    public Contrato obtenerContratoPorPostulacion(Long postulacionId) {
        return contratoRepo.findByPostulacion_Id(postulacionId);
    }
}