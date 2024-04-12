package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.parsers.MulParser;

/**
 * MulTest
 */
public class MulTest {
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new MulParser();
            var mul = parser.parse(0b001111011011);
            assertTrue(mul instanceof Mul);
            assertEquals(3, ((Mul) mul).getxReg());
            assertEquals(13, ((Mul) mul).getyReg());
            assertEquals(11, ((Mul) mul).getResultReg());
        });
    }
}
