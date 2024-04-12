package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cz.gvid.kripac.edvm.vm.parsers.OrParser;

/**
 * OrTest
 */
public class OrTest {
 
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new OrParser();
            var or = parser.parse(0b010011000111);
            assertTrue(or instanceof Or);
            assertEquals(4, ((Or) or).getxReg());
            assertEquals(12, ((Or) or).getyReg());
            assertEquals(7, ((Or) or).getResultReg());
        });
    } 
}
