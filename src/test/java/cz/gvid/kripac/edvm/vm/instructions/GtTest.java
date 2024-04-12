package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.Gt;
import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.parsers.GtParser;

/**
 * GtTest
 */
public class GtTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new GtParser();
            var gt = parser.parse(0b000011100101);
            assertTrue(gt instanceof Gt);
            assertEquals(0, ((Gt) gt).getxReg());
            assertEquals(14, ((Gt) gt).getyReg());
            assertEquals(5, ((Gt) gt).getResultReg());
        });
    }

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var registers = new MachineRegisters();
            registers.put(1, 1);
            registers.put(2, 10);
            var gt = new Gt(1, 2, 3);
            gt.eval(null, registers, null, null);
            assertEquals(0, registers.get(3));

            registers.put(2, 0);
            gt.eval(null, registers, null, null);
            assertEquals(1, registers.get(3));
        });
    }
}
