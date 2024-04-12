package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.parsers.SubParser;

/**
 * SubTest
 */
public class SubTest {
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new SubParser();
            var Mul = parser.parse(0b011111111010);
            assertTrue(Mul instanceof Sub);
            assertEquals(7, ((Sub) Mul).getxReg());
            assertEquals(15, ((Sub) Mul).getyReg());
            assertEquals(10, ((Sub) Mul).getResultReg());
        });
    }
}
