package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.Get;
import cz.gvid.kripac.edvm.vm.parsers.GetParser;

/**
 * GetTest
 */
public class GetTest {
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new GetParser();
            var get = parser.parse(0b100010100000);
            assertTrue(get instanceof Get);
            assertEquals(138, ((Get) get).getAddress());
            assertEquals(0, ((Get) get).getRegister());
        });
    }
}
