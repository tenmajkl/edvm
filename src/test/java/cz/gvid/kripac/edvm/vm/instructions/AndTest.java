package cz.gvid.kripac.edvm.vm.instructions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.And;
import cz.gvid.kripac.edvm.vm.parsers.AndParser;

/**
 * AndTest
 */
public class AndTest {

   @Test
   public void parsing() {
        assertDoesNotThrow(() -> {
            var parser = new AndParser();
            var and = parser.parse(0b100001110010);
            assertTrue(and instanceof And);
            assertEquals(8, ((And) and).getxReg());
            assertEquals(7, ((And) and).getyReg());
            assertEquals(2, ((And) and).getResultReg());
        });
   }
}
