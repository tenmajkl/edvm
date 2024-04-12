package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.parsers.NotParser;

/**
 * NotTest
 */
public class NotTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new NotParser();
            var not = parser.parse(0b011100000001);
            assertTrue(not instanceof Not);
            assertEquals(7, ((Not) not).getRegister());
        });
    }   

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var registers = new MachineRegisters();
            registers.put(1, 1);
            var not = new Not(1);
            not.eval(null, registers, null, null);
            assertEquals(0, registers.get(1));
            not.eval(null, registers, null, null);
            assertEquals(1, registers.get(1));
        });
    }
}
