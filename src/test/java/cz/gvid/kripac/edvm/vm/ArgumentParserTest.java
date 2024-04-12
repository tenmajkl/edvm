package cz.gvid.kripac.edvm.vm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;

/**
 * ArgumentParserTest
 */
public class ArgumentParserTest {
    @Test
    void parsing() throws InstructionException {
        assertEquals(
                Arrays.asList(2, 12), 
                ArgumentParser.parse(Arrays.asList(4, 8), 0b001000001100)
        );
    }

    @Test
    void parsingSmallerArguments() throws InstructionException {
        assertEquals(
                Arrays.asList(4), 
                ArgumentParser.parse(Arrays.asList(5), 0b001000000000)
        );
    }

    @Test
    void parsingZeros() throws InstructionException {
        assertEquals(
                Arrays.asList(0, 8), 
                ArgumentParser.parse(Arrays.asList(4, 8), 0b000000001000)
        );
    }

    @Test
    void parsingError() {
        assertThrows(InstructionException.class, () -> {
            ArgumentParser.parse(Arrays.asList(4, 9), 0b1000);
        });
    }
}
