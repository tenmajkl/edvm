package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;

/**
 * InstructionParser
 */
public interface InstructionParser {
    public Instruction parse(int arguments) throws InstructionException;
}
