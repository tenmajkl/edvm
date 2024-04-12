package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import cz.gvid.kripac.edvm.vm.instructions.Div;
import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.parsers.DivParser;

/**
 * DivTest
 */
public class DivTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new DivParser();
            var div = parser.parse(0b010111000100);
            assertTrue(div instanceof Div);
            assertEquals(5, ((Div) div).getxReg());
            assertEquals(12, ((Div) div).getyReg());
            assertEquals(4, ((Div) div).getResultReg());
        });
    }

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var registers = new MachineRegisters();
            registers.put(1, 6);
            registers.put(2, 2);
            var div = new Div(1, 2, 3);
            div.eval(null, registers, null, null);
            assertEquals(3, registers.get(3));

            registers.put(2, 4);
            div.eval(null, registers, null, null);
            assertEquals(1, registers.get(3));
        });

        assertThrows(VMRuntimeException.class, () -> {
            var registers = new MachineRegisters();
            registers.put(1, 37);
            registers.put(2, 0);
            var div = new Div(1, 2, 3);
            div.eval(null, registers, null, null);
        });
    }

}
