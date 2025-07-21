package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Capacitacion;
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
public class CapacitacionServiceTest {
    
    public CapacitacionServiceTest() {
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
     * Test of obtenerTodas method, of class CapacitacionService.
     */
    @Test
    public void testObtenerTodas() {
        System.out.println("obtenerTodas");
        CapacitacionService instance = new CapacitacionService();
        List<Capacitacion> expResult = null;
        List<Capacitacion> result = instance.obtenerTodas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar method, of class CapacitacionService.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Capacitacion capacitacion = null;
        CapacitacionService instance = new CapacitacionService();
        instance.guardar(capacitacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class CapacitacionService.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Long id = null;
        CapacitacionService instance = new CapacitacionService();
        Capacitacion expResult = null;
        Capacitacion result = instance.obtenerPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
