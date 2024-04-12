package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.parsers.SysParser;

/**
 * SysTest
 */
public class SysTest {
    @Test
    public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new SysParser();
            var sys = parser.parse(0b011010011111);
            assertTrue(sys instanceof Sys);
            assertEquals(6, ((Sys) sys).getId());
            assertEquals(9, ((Sys) sys).getInputReg());
            assertEquals(15, ((Sys) sys).getOutputReg());
        });
    }
}
