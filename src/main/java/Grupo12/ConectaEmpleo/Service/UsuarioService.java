package Grupo12.ConectaEmpleo.Service;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Usuario;
import Grupo12.ConectaEmpleo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean correoExiste(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public Usuario autenticar(String correo, String contrasena) {
    Usuario u = usuarioRepository.findByCorreo(correo);
    if (u != null && u.getContrasena().equals(contrasena)) {
        return u;
    }
    return null;
}

}

