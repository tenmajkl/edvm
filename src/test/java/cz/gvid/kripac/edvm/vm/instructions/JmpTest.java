package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import cz.gvid.kripac.edvm.vm.parsers.JmpParser;

/**
 * JmpTest
 */
public class JmpTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new JmpParser();
            var jmp = parser.parse(0b010101000000);
            assertTrue(jmp instanceof Jmp);
            assertEquals(84, ((Jmp) jmp).getInstruction());
        });
    } 

    @Test
    public void executing() {
        assertDoesNotThrow(() -> {
            var ptr = new InstructionPointer();
            var add = new Jmp(5);
            add.eval(null, null, null, ptr);
            assertEquals(4, ptr.getPointer());
        });

        assertThrows(VMRuntimeException.class, () -> {
            var add = new Jmp(1024);
            var ptr = new InstructionPointer();
            add.eval(null, null, null, ptr);          
        });
    }
}
