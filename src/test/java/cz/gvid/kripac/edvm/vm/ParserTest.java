package cz.gvid.kripac.edvm.vm;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.instructions.Jmp;
import cz.gvid.kripac.edvm.vm.instructions.Set;
import cz.gvid.kripac.edvm.vm.instructions.Srv;

/**
 * ParserTest
 */
public class ParserTest {

    @Test
    public void testParsing() {
        assertDoesNotThrow(() -> {
            var parser = new Parser();
            var result = parser.parse(Arrays.asList(
                            0b0000100000001111,
                            0b1000000000000000,
                            0b1010000011110011
                        ));
            assertTrue(result.get(0) instanceof Srv);
            assertTrue(result.get(1) instanceof Jmp);
            assertTrue(result.get(2) instanceof Set);
        });
    }
}
