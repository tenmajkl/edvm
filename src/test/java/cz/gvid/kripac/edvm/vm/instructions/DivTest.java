package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.Div;
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
}
