package Grupo12.ConectaEmpleo.Model;

/**
 *
 * @author Home
 */
import jakarta.persistence.*;

@Entity
@Table(name = "participante_capacitacion")
public class ParticipanteCapacitacion {

    @EmbeddedId
    private ParticipanteCapacitacionId id = new ParticipanteCapacitacionId();

    private Boolean certificado;
    private Integer calificacionAlumno;

    @ManyToOne
    @MapsId("usuarioId")
    private Usuario usuario;

    @ManyToOne
    @MapsId("capacitacionId")
    private Capacitacion capacitacion;

    //Getters y Setters
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

