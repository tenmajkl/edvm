package cz.gvid.kripac.edvm.asm.contracts;

import cz.gvid.kripac.edvm.asm.Addresses;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public interface Argument {
    /**
     * Converts given token into numeric value
     * @param input string token
     * @return parsed numeric value 
     * @throws AssemblerInstructionException when given token doesnt match argument rules
     */
    public int compile(String input, Addresses addresses) throws AssemblerInstructionException;
}
