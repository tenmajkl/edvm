package cz.gvid.kripac.edvm.asm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BytecodeGeneratorTest {
    @Test
    public void conversion() {
        assertEquals(0b0011110101110101, BytecodeGenerator.convert(
            3,
            Arrays.asList(13, 7, 5),
            Arrays.asList(4, 4, 4)
            ));

        assertEquals(0b1011100000000111, BytecodeGenerator.convert(
            11,
            Arrays.asList(128, 7),
            Arrays.asList(8, 4)
            ));
    }
}
