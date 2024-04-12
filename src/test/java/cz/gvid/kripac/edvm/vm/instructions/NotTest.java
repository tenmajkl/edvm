package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.parsers.NotParser;

/**
 * NotTest
 */
public class NotTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new NotParser();
            var not = parser.parse(0b011100000001);
            assertTrue(not instanceof Not);
            assertEquals(7, ((Not) not).getRegister());
        });
    }    
}
