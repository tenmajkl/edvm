package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.parsers.SrvParser;

/**
 * SrvTest
 */
public class SrvTest {

    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new SrvParser(); 
            var srv = parser.parse(0b011110101000);
            assertTrue(srv instanceof Srv);
            assertEquals(7, ((Srv) srv).getRegister());
            assertEquals(168, ((Srv) srv).getValue());
        });
    }
}
