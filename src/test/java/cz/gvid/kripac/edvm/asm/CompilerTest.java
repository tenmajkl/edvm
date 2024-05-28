package cz.gvid.kripac.edvm.asm;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public class CompilerTest {
    @Test
    public void compileTag() {
        var comp = new Compiler();
        assertTrue(comp.compileTag("foo:"));
        assertTrue(comp.compileTag("  foo:    "));
        assertFalse(comp.compileTag("srv 1 2"));
        assertFalse(comp.compileTag("parek"));
    }

    @Test
    public void compileInstruction() {
        assertDoesNotThrow(() -> {
            var comp = new Compiler();
            assertTrue(comp.compileInstruction("srv 12 130"));
        });

        assertThrows(AssemblerInstructionException.class, () -> {
            var comp = new Compiler();
            comp.compileInstruction("srv 12 370");
        });

        assertThrows(AssemblerInstructionException.class, () -> {
            var comp = new Compiler();
            comp.compileInstruction("srv");
        });
    }

    @Test
    public void compileLine() {
        assertDoesNotThrow(() -> {
            var comp = new Compiler();
            assertTrue(comp.compileLine("add 1 2 3"));
            assertTrue(comp.compileLine("hello:"));
        });
    }

    @Test
    public void compile() {
        assertDoesNotThrow(() -> {
            var stream = new FileInputStream("test.esm");
            var comp = new Compiler();
            assertEquals(Arrays.asList(
                0b0000000001100001,
                0b1100000100000010,
                0b1000000000010000
                ), comp.compile(stream));
            stream.close();
        });
    }
}
