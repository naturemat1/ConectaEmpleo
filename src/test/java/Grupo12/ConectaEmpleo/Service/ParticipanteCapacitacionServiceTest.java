package Grupo12.ConectaEmpleo.Service;

import Grupo12.ConectaEmpleo.Model.Capacitacion;
import Grupo12.ConectaEmpleo.Model.ParticipanteCapacitacion;
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
public class ParticipanteCapacitacionServiceTest {
    
    public ParticipanteCapacitacionServiceTest() {
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
     * Test of inscribirUsuarioEnCapacitacion method, of class ParticipanteCapacitacionService.
     */
    @Test
    public void testInscribirUsuarioEnCapacitacion() {
        System.out.println("inscribirUsuarioEnCapacitacion");
        Usuario usuario = null;
        Capacitacion capacitacion = null;
        ParticipanteCapacitacionService instance = new ParticipanteCapacitacionService();
        instance.inscribirUsuarioEnCapacitacion(usuario, capacitacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByTrabajador method, of class ParticipanteCapacitacionService.
     */
    @Test
    public void testFindByTrabajador() {
        System.out.println("findByTrabajador");
        Usuario usuario = null;
        ParticipanteCapacitacionService instance = new ParticipanteCapacitacionService();
        List<ParticipanteCapacitacion> expResult = null;
        List<ParticipanteCapacitacion> result = instance.findByTrabajador(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
