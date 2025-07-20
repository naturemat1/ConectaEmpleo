package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
    Usuario findByCorreo(String correo);
}

