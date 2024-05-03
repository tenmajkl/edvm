package cz.gvid.kripac.edvm.asm.arguments;

import cz.gvid.kripac.edvm.asm.Addresses;
import cz.gvid.kripac.edvm.asm.contracts.Argument;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public class Address implements Argument {
    /**
     * {@inheritDoc}
     */
    @Override
    public int compile(String input, Addresses addresses) throws AssemblerInstructionException {
        if (!addresses.hasAddress(input)) {
            throw new AssemblerInstructionException("Unknown address tag " + input);
        }

        return addresses.getAddress(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return 8;
    }
}
