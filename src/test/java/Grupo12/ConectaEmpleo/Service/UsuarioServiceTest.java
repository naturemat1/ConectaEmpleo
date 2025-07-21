package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Home
 */
public class UsuarioServiceTest {
    
    public UsuarioServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of correoExiste method, of class UsuarioService.
     */
    @Test
    public void testCorreoExiste() {
        System.out.println("correoExiste");
        String correo = "";
        UsuarioService instance = new UsuarioService();
        boolean expResult = false;
        boolean result = instance.correoExiste(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar method, of class UsuarioService.
     */
    @Test
    public void testRegistrar() {
        System.out.println("registrar");
        Usuario usuario = null;
        UsuarioService instance = new UsuarioService();
        Usuario expResult = null;
        Usuario result = instance.registrar(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autenticar method, of class UsuarioService.
     */
    @Test
    public void testAutenticar() {
        System.out.println("autenticar");
        String correo = "";
        String contrasena = "";
        UsuarioService instance = new UsuarioService();
        Usuario expResult = null;
        Usuario result = instance.autenticar(correo, contrasena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCalificacionPromedio method, of class UsuarioService.
     */
    @Test
    public void testActualizarCalificacionPromedio() {
        System.out.println("actualizarCalificacionPromedio");
        Usuario usuario = null;
        Integer nuevaPuntuacion = null;
        UsuarioService instance = new UsuarioService();
        instance.actualizarCalificacionPromedio(usuario, nuevaPuntuacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
