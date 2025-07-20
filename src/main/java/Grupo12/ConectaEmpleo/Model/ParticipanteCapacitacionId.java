package Grupo12.ConectaEmpleo.Model;

/**
 *
 * @author Home
 */
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticipanteCapacitacionId implements Serializable {

    private Long usuarioId;
    private Long capacitacionId;

    // equals y hashCode obligatorios
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.usuarioId);
        hash = 31 * hash + Objects.hashCode(this.capacitacionId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParticipanteCapacitacionId other = (ParticipanteCapacitacionId) obj;
        if (!Objects.equals(this.usuarioId, other.usuarioId)) {
            return false;
        }
        return Objects.equals(this.capacitacionId, other.capacitacionId);
    }
    
    
    //Getters y Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCapacitacionId() {
        return capacitacionId;
    }

    public void setCapacitacionId(Long capacitacionId) {
        this.capacitacionId = capacitacionId;
    }
    
}

