package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Postulacion;
import Grupo12.ConectaEmpleo.Model.Trabajo;
import Grupo12.ConectaEmpleo.Model.Usuario;
import java.util.List;
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
public class PostulacionServiceTest {
    
    public PostulacionServiceTest() {
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
     * Test of postularse method, of class PostulacionService.
     */
    @Test
    public void testPostularse() {
        System.out.println("postularse");
        Usuario trabajador = null;
        Trabajo trabajo = null;
        PostulacionService instance = new PostulacionService();
        instance.postularse(trabajador, trabajo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByTrabajador method, of class PostulacionService.
     */
    @Test
    public void testFindByTrabajador() {
        System.out.println("findByTrabajador");
        Usuario trabajador = null;
        PostulacionService instance = new PostulacionService();
        List<Postulacion> expResult = null;
        List<Postulacion> result = instance.findByTrabajador(trabajador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aceptarPostulacion method, of class PostulacionService.
     */
    @Test
    public void testAceptarPostulacion() {
        System.out.println("aceptarPostulacion");
        Long id = null;
        PostulacionService instance = new PostulacionService();
        Postulacion expResult = null;
        Postulacion result = instance.aceptarPostulacion(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
