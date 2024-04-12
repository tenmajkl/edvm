package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;

/**
 * InstructionParser
 */
public interface InstructionParser {
    /**
     * Parses Instruction from integer into object representation.
     *
     * @param arguments Integer representation of instruction arguments
     * @return Object representation of instruction
     * @throws InstructionException
    */
    public Instruction parse(int arguments) throws InstructionException;
}
