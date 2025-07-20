package Grupo12.ConectaEmpleo.Repository;

import Grupo12.ConectaEmpleo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para manejar operaciones de persistencia con la entidad Usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
    Usuario findByCorreo(String correo);
}