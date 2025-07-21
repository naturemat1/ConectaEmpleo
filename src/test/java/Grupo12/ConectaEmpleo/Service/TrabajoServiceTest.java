package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Trabajo;
import java.util.List;
import java.util.Map;
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
public class TrabajoServiceTest {
    
    public TrabajoServiceTest() {
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
     * Test of guardarTrabajo method, of class TrabajoService.
     */
    @Test
    public void testGuardarTrabajo() {
        System.out.println("guardarTrabajo");
        Trabajo trabajo = null;
        TrabajoService instance = new TrabajoService();
        instance.guardarTrabajo(trabajo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class TrabajoService.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        TrabajoService instance = new TrabajoService();
        List<Trabajo> expResult = null;
        List<Trabajo> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class TrabajoService.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Long id = null;
        TrabajoService instance = new TrabajoService();
        Trabajo expResult = null;
        Trabajo result = instance.obtenerPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorCategoriaOUbicacion method, of class TrabajoService.
     */
    @Test
    public void testBuscarPorCategoriaOUbicacion() {
        System.out.println("buscarPorCategoriaOUbicacion");
        String categoria = "";
        String ubicacion = "";
        TrabajoService instance = new TrabajoService();
        List<Trabajo> expResult = null;
        List<Trabajo> result = instance.buscarPorCategoriaOUbicacion(categoria, ubicacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCategoriasConMasOfertas method, of class TrabajoService.
     */
    @Test
    public void testObtenerCategoriasConMasOfertas() {
        System.out.println("obtenerCategoriasConMasOfertas");
        TrabajoService instance = new TrabajoService();
        Map<String, Long> expResult = null;
        Map<String, Long> result = instance.obtenerCategoriasConMasOfertas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class TrabajoService.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Trabajo trabajo = null;
        TrabajoService instance = new TrabajoService();
        instance.eliminar(trabajo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
