package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.St;
import cz.gvid.kripac.edvm.vm.parsers.StParser;

/**
 * StTest
 */
public class StTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new StParser();
            var st = parser.parse(0b010010101101);
            assertTrue(st instanceof St);
            assertEquals(4, ((St) st).getxReg());
            assertEquals(10, ((St) st).getyReg());
            assertEquals(13, ((St) st).getResultReg());
        });
    } 
}
