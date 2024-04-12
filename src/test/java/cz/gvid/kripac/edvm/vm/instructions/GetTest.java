package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.Get;
import cz.gvid.kripac.edvm.vm.machine.MachineMemory;
import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.parsers.GetParser;

/**
 * GetTest
 */
public class GetTest {
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new GetParser();
            var get = parser.parse(0b100010100000);
            assertTrue(get instanceof Get);
            assertEquals(138, ((Get) get).getAddress());
            assertEquals(0, ((Get) get).getRegister());
        });
    }

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var registers = new MachineRegisters();
            var memory = new MachineMemory();
            memory.put(0, 255);
            var get = new Get(0, 0);
            get.eval(memory, registers, null, null);
            assertEquals(255, registers.get(0));

            get = new Get(1, 0);
            get.eval(memory, registers, null, null);
            assertEquals(0, registers.get(0));
        });
    }
}
