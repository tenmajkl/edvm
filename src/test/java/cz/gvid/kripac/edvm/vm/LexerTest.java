package cz.gvid.kripac.edvm.vm;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;

import org.junit.jupiter.api.Test;

/**
 * LexerTest
 */
public class LexerTest {

    @Test
    public void lexing() {
        assertDoesNotThrow(() -> {
            var file = new FileInputStream("test.ebin");
            var lexer = new Lexer();
            var result = lexer.lex(file);
            assertEquals(0b0000000000000100, result.get(0));
            assertEquals(0b0000000100000101, result.get(1));
            assertEquals(0b0001000000010010, result.get(2));
            assertEquals(3, result.size());
            file.close();
        });
    }
}
