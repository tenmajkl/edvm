package cz.gvid.kripac.edvm.vm.parsers;

import org.junit.jupiter.api.Test;

/**
 * GetTest
 */
public class GetTest {
    @Test
    public void parsing() {
        var paraser = new GetParser();
        var get = parser.parse(0b000010101111);
        
    }
}
