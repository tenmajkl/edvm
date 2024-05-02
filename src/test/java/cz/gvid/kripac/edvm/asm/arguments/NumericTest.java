package cz.gvid.kripac.edvm.asm.arguments;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.asm.Addresses;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public class NumericTest {
    @Test
    public void compiling() {
        assertDoesNotThrow(() -> {
            var n = new Numeric(8);
            var addr = new Addresses();
            assertEquals(37, n.compile("37", addr));
        });

        assertThrows(AssemblerInstructionException.class, () -> {
            var n = new Numeric(8);
            var addr = new Addresses();     
            n.compile("370", addr);
        });
    }
}
