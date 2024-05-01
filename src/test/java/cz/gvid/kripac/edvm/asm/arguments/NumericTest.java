package cz.gvid.kripac.edvm.asm.arguments;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.asm.Addresses;

class NumericTest {
    @Test
    public void compiling() {
        assertDoesNotThrow(() -> {
            var n = new Numeric(8);
            var addr = new Addresses();
            addr.setAddress("foo", 10);
        });
    }
}
