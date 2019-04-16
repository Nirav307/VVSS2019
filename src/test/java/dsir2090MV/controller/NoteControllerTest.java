package dsir2090MV.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import dsir2090MV.main.ClasaException;
import dsir2090MV.model.Nota;
import dsir2090MV.utils.Constants;

import static org.junit.Assert.*;

public class NoteControllerTest {
    private NoteController ctrl;

    @Before
    public void init(){
        ctrl = new NoteController();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    // Region ECP
    /*
     * Test1 valid ECP
     */
    @Test
    public void Test1ValidECP() throws ClasaException {
        ctrl.addNota(new Nota(1, "Matematica", 9));
        assertEquals(ctrl.getNote().size(), 1);
    }
    /*
     * Test2 valid ECP
     */
    @Test
    public void Test2ValidECP() throws ClasaException {
        ctrl.addNota(new Nota(1, "Matee", 2));
        assertEquals(ctrl.getNote().size(), 1);
    }
    /*
     * Test3 valid ECP
     */
    @Test
    public void Test3ValidECP() throws ClasaException {
        ctrl.addNota(new Nota(1, "Mate", 9));
        assertEquals(ctrl.getNote().size(), 1);
    }
    /*
     * Test4 valid ECP
     */
    @Test
    public void Test4ValidECP() throws ClasaException {
        ctrl.addNota(new Nota(1, "Mate", 8));
        assertEquals(ctrl.getNote().size(), 1);
    }
    /*
     * Test1 nonvalid ECP
     */
    @Test
    public void Test1NonValidECP() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(1, "Mate", -1));
    }
    /*
     * Test2 nonvalid ECP
     */
    @Test
    public void Test2NonValidECP() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(1, "Mate", 15));
    }
    /*
     * Test3 nonvalid ECP
     */
    @Test
    public void Test3NonValidECP() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidMateria);
        ctrl.addNota(new Nota(1, "Mateeeeeeeeeeeeeeeeeeeeeee", 5));
    }
    /*
     * Test4 nonvalid ECP
     */
    @Test
    public void Test4NonValidECP() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidMateria);
        ctrl.addNota(new Nota(1, "M", 5));
    }

    // Endregion ECP


    // Region BVA

    /*
    * Test1 valid BVA
    * Nota == valoare maxima valida == 10
    */
    @Test
    public void Test1ValidBVA() throws ClasaException {
        ctrl.addNota(new Nota(1, "Mate", 10));
        assertEquals(ctrl.getNote().size(), 1);
    }
    /*
     * Test2 valid BVA
     * Nota == valoare minima valida == 1
     */
    @Test
    public void Test2ValidBVA() throws ClasaException {
        ctrl.addNota(new Nota(1, "Matematica", 1));
        assertEquals(ctrl.getNote().size(), 1);
    }
    /*
     * Test2 valid BVA
     * materie.Length() == 20
     */
    @Test
    public void Test3ValidBVA() throws ClasaException {
        ctrl.addNota(new Nota(1, "Matematicaaaaaaaaaaa", 10));
        assertEquals(ctrl.getNote().size(), 1);
    }
    /*
    * Test1 nonvalid BVA
    * Nota == valoarea de stanga maxima nonvalida == 0
    */
    @Test
    public void Test1NonValidBVA() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(1, "Mate", 0));
    }
    /*
     * Test2 nonvalid BVA
     * Nota == valoarea de dreapta minima nonvalida == 11
     */
    @Test
    public void Test2NonValidBVA() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(1, "Mate", 11));
    }

    // End region BVA

}
