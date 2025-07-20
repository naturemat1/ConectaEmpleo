package Grupo12.ConectaEmpleo.Model;

/**
 *
 * @author Home
 */
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "capacitacion")
public class Capacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "capacitador_id")
    private Usuario capacitador;

    @OneToMany(mappedBy = "capacitacion", cascade = CascadeType.ALL)
    private List<ParticipanteCapacitacion> participantes;

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getCapacitador() {
        return capacitador;
    }

    public void setCapacitador(Usuario capacitador) {
        this.capacitador = capacitador;
    }

    public List<ParticipanteCapacitacion> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipanteCapacitacion> participantes) {
        this.participantes = participantes;
    }
    
}

