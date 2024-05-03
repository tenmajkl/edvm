package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.instructions.Add;
import cz.gvid.kripac.edvm.vm.machine.MachineMemory;
import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.machine.MachineSystem;
import cz.gvid.kripac.edvm.vm.parsers.AddParser;

/**
 * AddTest
 */
public class AddTest {
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new AddParser();
            var add = parser.parse(0b000101011001);
            assertTrue(add instanceof Add);
            assertEquals(1, ((Add) add).getxReg());
            assertEquals(5, ((Add) add).getyReg());
            assertEquals(9, ((Add) add).getResultReg());
        });
    }

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var registers = new MachineRegisters();
            var add = new Add(1, 2, 3);
            registers.put(1, 1);
            registers.put(2, 1);
            add.eval(null, registers, null, null);
            assertEquals(2, registers.get(3));

            registers.put(2, 255);
            add.eval(null, registers, null, null);
            assertEquals(0, registers.get(3));

            add = new Add(1, 4, 3);
            add.eval(null, registers, null, null);
            assertEquals(1, registers.get(3));

            add = new Add(1, 2, 1);
            registers.put(1, 1);
            registers.put(2, 1);
            add.eval(null, registers, null, null);
            assertEquals(2, registers.get(1));
        });
    }
}
