package cz.gvid.kripac.edvm.asm.arguments;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import cz.gvid.kripac.edvm.asm.Addresses;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public class AddressTest {
    @Test
    public void compiling() {
        assertDoesNotThrow(() -> {
            var addresses = new Addresses();
            addresses.setAddress("foo", 37);
            var comp = new Address();
            assertEquals(37, comp.compile("foo", addresses));
        });

        assertThrows(AssemblerInstructionException.class, () -> {
            var addresses = new Addresses();
            addresses.setAddress("foo", 37);
            var comp = new Address();    
            comp.compile("bar", addresses);
        });
    }
}
