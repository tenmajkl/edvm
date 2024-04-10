package cz.gvid.kripac.edvm.vm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * ArgumentParserTest
 */
public class ArgumentParserTest {
    @Test
    void parsing() {
        assertEquals(
                Arrays.asList(2, 12), 
                ArgumentParser.parse(Arrays.asList(4, 8), 0b001000001100)
        );
    }

    @Test
    void parsingSmallerArguments() {
        assertEquals(
                Arrays.asList(4), 
                ArgumentParser.parse(Arrays.asList(5), 0b001000000000)
        );
    }
}
