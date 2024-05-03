package cz.gvid.kripac.edvm.asm.arguments;

import cz.gvid.kripac.edvm.asm.Addresses;
import cz.gvid.kripac.edvm.asm.contracts.Argument;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public class Numeric implements Argument {
    
    private int size;

    public Numeric(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compile(String input, Addresses addresses) throws AssemblerInstructionException {
        try {
            int numeric = Integer.parseInt(input);
            if (numeric >= Math.pow(2, size)) {
                throw new AssemblerInstructionException("Number is too large! Maximal allowed size is " + size + " bits");
            }
            return numeric;
        } catch (NumberFormatException e) {
            throw new AssemblerInstructionException("Unexpected token " + input + " expected integer");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return size;
    }
}
