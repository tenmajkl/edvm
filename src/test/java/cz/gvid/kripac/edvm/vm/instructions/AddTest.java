package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.instructions.Add;
import cz.gvid.kripac.edvm.vm.parsers.AddParser;

/**
 * AddTest
 */
public class AddTest {
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new AddParser();
            var add = parser.parse(0b000101011001);
            assertTrue(add instanceof Add);
            assertEquals(1, ((Add) add).getxReg());
            assertEquals(5, ((Add) add).getyReg());
            assertEquals(9, ((Add) add).getResultReg());
        });
    }
}
