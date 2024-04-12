package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.parsers.JzrParser;

/**
 * JzrTest
 */
public class JzrTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new JzrParser(); 
            var jzr = parser.parse(0b011110101000);
            assertTrue(jzr instanceof Jzr);
            assertEquals(7, ((Jzr) jzr).getRegister());
            assertEquals(168, ((Jzr) jzr).getInstruction());
        });
    }

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var ptr = new InstructionPointer();
            var registers = new MachineRegisters();
            var jzr = new Jzr(0, 5);

            registers.put(0, 0);
            jzr.eval(null, registers, null, ptr);
            assertEquals(4, ptr.getPointer());

            registers.put(0, 1);
            jzr.eval(null, registers, null, ptr);
            assertEquals(4, ptr.getPointer());

        });

        assertThrows(VMRuntimeException.class, () -> {
            var add = new Jmp(1024);
            var ptr = new InstructionPointer();
            add.eval(null, null, null, ptr);          
        });
    }
}
