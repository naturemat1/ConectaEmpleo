package Grupo12.ConectaEmpleo.Model;

import jakarta.persistence.*;

/**
 * Entidad que representa la inscripción de un usuario a una capacitación.
 * Tiene una clave compuesta (usuarioId + capacitacionId)
 */
@Entity
@Table(name = "participante_capacitacion")
public class ParticipanteCapacitacion {

    @EmbeddedId
    private ParticipanteCapacitacionId id = new ParticipanteCapacitacionId();

    private Boolean certificado;
    private Integer calificacionAlumno;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("capacitacionId")
    @JoinColumn(name = "capacitacion_id")
    private Capacitacion capacitacion;

    // Getters y Setters
    public ParticipanteCapacitacionId getId() {
        return id;
    }

    public void setId(ParticipanteCapacitacionId id) {
        this.id = id;
    }

    public Boolean getCertificado() {
        return certificado;
    }

    public void setCertificado(Boolean certificado) {
        this.certificado = certificado;
    }

    public Integer getCalificacionAlumno() {
        return calificacionAlumno;
    }

    public void setCalificacionAlumno(Integer calificacionAlumno) {
        this.calificacionAlumno = calificacionAlumno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }
}