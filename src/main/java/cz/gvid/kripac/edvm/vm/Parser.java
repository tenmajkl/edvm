package cz.gvid.kripac.edvm.vm;

import java.util.ArrayList;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.InstructionParser;

/**
 * Parser
 */
public class Parser {

    /**
     * Mask for obtaining argument part from instruction.
     * If you use bitwise and operator on instruction, it will remove 4 identifier bits
     */
    public static final int ArgumentMask = 0b0000111111111111;

    private ArrayList<InstructionParser> parsers = new ArrayList<InstructionParser>();

    public Parser() {
    }

    public Parser addParser(InstructionParser parser) {
        this.parsers.add(parser);
        return this;
    }

    public Instructions parse(ArrayList<Integer> code) {
         var instructions = new ArrayList<Instruction>();
         for (int instruction : code) {
            int id = instruction >> 12;
            int arguments = instruction & ArgumentMask;
            instructions.add(this.parsers.get(id).parse(arguments));
         }

         return new Instructions(instructions);
    }
}
