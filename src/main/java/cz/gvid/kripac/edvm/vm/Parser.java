package cz.gvid.kripac.edvm.vm;

import java.util.ArrayList;
import java.util.List;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.InstructionParser;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.parsers.*;

/**
 * Parser
 */
public class Parser {

    /**
     * Mask for obtaining argument part from instruction.
     * If you use bitwise *and* operator on instruction, it will remove 4 identifier bits
     */
    public static final int ArgumentMask = 0b0000111111111111;

    /**
     * Maximum size of instruction.
     * Since every instruction is represented as 16b integer, max numeric value it can have is 2^16
     */
    public static final int MaxInstructionValue = 65536; // == 2^16

    private ArrayList<InstructionParser> parsers = new ArrayList<InstructionParser>();

    public Parser() {
        this.initDefaultParsers();
    }

    /**
     * Parses list of integer instructions into list of object instructions
     * @param code integer instructions 
     * @return object instructions
    */
    public List<Instruction> parse(ArrayList<Integer> code) throws InstructionException {
         var instructions = new ArrayList<Instruction>();
         int counter = 0;
         for (int instruction : code) {
            // This check would not be nescessary when the input was from binary file, 
            // but if someone uses it directly its important.
            if (instruction > MaxInstructionValue) {
                throw new InstructionException("Instruction " + counter + " is too long, maximal allowed size is 16 bits");
            }
            int id = instruction >> 12;
            int arguments = instruction & ArgumentMask;
            instructions.add(this.parsers.get(id).parse(arguments));
            counter++;
         }

         return instructions;
    }

    private Parser addParser(int id, InstructionParser parser) {
        this.parsers.add(id, parser);
        return this;
    }

    private void initDefaultParsers() {
        this.addParser(0b0000, new SrvParser())
            .addParser(0b0001, new AddParser())
            .addParser(0b0010, new SubParser())
            .addParser(0b0011, new MulParser())
            .addParser(0b0100, new DivParser())
            .addParser(0b0101, new OrParser())
            .addParser(0b0110, new NotParser())
            .addParser(0b0111, new AndParser())
            .addParser(0b1000, new JmpParser())
            .addParser(0b1001, new JzrParser())
            .addParser(0b1010, new SetParser())
            .addParser(0b1011, new GetParser())
            .addParser(0b1100, new SysParser())
            .addParser(0b1101, new EquParser())
            .addParser(0b1110, new StParser())
            .addParser(0b1111, new GtParser());
    }
}
