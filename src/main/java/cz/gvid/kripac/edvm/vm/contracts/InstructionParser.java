package cz.gvid.kripac.edvm.vm.contracts;

/**
 * InstructionParser
 */
public interface InstructionParser {
    public Instruction parse(int arguments);
}
