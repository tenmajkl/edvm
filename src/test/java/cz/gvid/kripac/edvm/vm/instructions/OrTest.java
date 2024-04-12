package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.parsers.OrParser;

/**
 * OrTest
 */
public class OrTest {
 
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new OrParser();
            var or = parser.parse(0b010011000111);
            assertTrue(or instanceof Or);
            assertEquals(4, ((Or) or).getxReg());
            assertEquals(12, ((Or) or).getyReg());
            assertEquals(7, ((Or) or).getResultReg());
        });
    } 

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var registers = new MachineRegisters();
            registers.put(1, 1);
            registers.put(2, 0);
            var or = new Or(1, 2, 3);
            or.eval(null, registers, null, null);
            assertEquals(1, registers.get(3));
            registers.put(2, 5);
            or.eval(null, registers, null, null);
            assertEquals(1, registers.get(3));
            registers.put(1, 0);
            or.eval(null, registers, null, null);
            assertEquals(1, registers.get(3));
            registers.put(2, 0);
            or.eval(null, registers, null, null);
            assertEquals(0, registers.get(3));
        });
    }
}
