package cz.gvid.kripac.edvm.vm.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.instructions.Equ;

/**
 * EquTest
 */
public class EquTest {
    @Test
    public void parsing() {
        var parser = new EquParser();
        var equ = parser.parse(0b011111011100);
        assertTrue(equ instanceof Equ);
        assertEquals(7, ((Equ) equ).getxReg());
        assertEquals(13, ((Equ) equ).getyReg());
        assertEquals(12, ((Equ) equ).getResultReg());
    }
}
