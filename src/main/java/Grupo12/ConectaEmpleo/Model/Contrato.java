package Grupo12.ConectaEmpleo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer calificacionTrabajador;
    private Integer calificacionSolicitante;
    private String comentarios;

    @OneToOne
    @JoinColumn(name = "postulacion_id")
    private Postulacion postulacion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCalificacionTrabajador() {
        return calificacionTrabajador;
    }

    public void setCalificacionTrabajador(Integer calificacionTrabajador) {
        this.calificacionTrabajador = calificacionTrabajador;
    }

    public Integer getCalificacionSolicitante() {
        return calificacionSolicitante;
    }

    public void setCalificacionSolicitante(Integer calificacionSolicitante) {
        this.calificacionSolicitante = calificacionSolicitante;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }
}
