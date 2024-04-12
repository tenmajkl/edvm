package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
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
}
