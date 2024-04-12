package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.machine.MachineMemory;
import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.parsers.SetParser;

/**
 * SetTest
 */
public class SetTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new SetParser(); 
            var set = parser.parse(0b011110101000);
            assertTrue(set instanceof Set);
            assertEquals(122, ((Set) set).getAddress());
            assertEquals(8, ((Set) set).getRegister());
        });
    }

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var registers = new MachineRegisters();
            var memory = new MachineMemory();
            registers.put(0, 37);
            var set = new Set(0, 0);
            set.eval(memory, registers, null, null);
            assertEquals(37, memory.get(0));
        });
    }
}