package cz.gvid.kripac.edvm.asm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import cz.gvid.kripac.edvm.asm.arguments.Address;
import cz.gvid.kripac.edvm.asm.arguments.Numeric;
import cz.gvid.kripac.edvm.asm.contracts.Argument;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public class Compiler {
    private HashMap<String, Entry<Integer, List<Argument>>> instructions = new HashMap<String, Entry<Integer, List<Argument>>>();
    private Addresses addresses = new Addresses();
    private int line = 0;
    private ArrayList<Integer> result = new ArrayList<Integer>();

    public Compiler() {
        this.addInstruction("srv", 0, Arrays.asList(new Numeric(4), new Numeric(8)));
        this.addInstruction("add", 1, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("sub", 2, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("mul", 3, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("div", 4, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("or",  5, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("not", 6, Arrays.asList(new Numeric(4)));
        this.addInstruction("and", 7, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("jmp", 8, Arrays.asList(new Address()));
        this.addInstruction("jzr", 9, Arrays.asList(new Numeric(4), new Address()));
        this.addInstruction("set", 10, Arrays.asList(new Numeric(8), new Numeric(4)));
        this.addInstruction("get", 11, Arrays.asList(new Numeric(8), new Numeric(4)));
        this.addInstruction("sys", 12, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("equ", 13, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("gt",  14, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        this.addInstruction("st",  15, Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
    }

    private void addInstruction(String name, int id, List<Argument> arguments) {
        instructions.put(name, new SimpleEntry<Integer, List<Argument>>(id, arguments));
    }

    /**
     * Tries to compile line with address tag
     * @param line
     * @return
     */
    public boolean compileTag(String line) {
        var pattern = Pattern.compile("^\\s*([a-zA-Z0-9_]+):\\s*$");
        var matcher = pattern.matcher(line);
        if (!matcher.find()) {
            return false;
        }

        this.addresses.setAddress(matcher.group(1), this.line);
        this.line--; // we need to skip this line basicaly

        return true;
    }

    /**
     * @param line
     * @throws AssemblerInstructionException
     */
    public boolean compileInstruction(String line) throws AssemblerInstructionException {
        var tokens = line.split("\\s+");
        Entry<Integer, List<Argument>> instruction;
        if (Pattern.matches("^\\s+$", line)) {
            return true;
        }

        if ((instruction = this.instructions.get(tokens[0])) == null) {
            throw new AssemblerInstructionException("Unknown instruction " + tokens[0]);
        }

        var args = instruction.getValue();

        var result = new ArrayList<Integer>();

        var pattern = new ArrayList<Integer>();

        int index = 0;
        try {
            for (; index < args.size(); index++) {
                result.add(
                        args.get(index).compile(tokens[index + 1], this.addresses)
                );
                pattern.add(args.get(index).getSize());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AssemblerInstructionException("Missing argument " + index);
        }

        this.result.add(BytecodeGenerator.convert(instruction.getKey(), result, pattern));

        return true;
    }

    public boolean compileLine(String line) throws AssemblerInstructionException {
        try {
            return this.compileTag(line) || this.compileInstruction(line); 
        } catch (AssemblerInstructionException e) {
            throw e.setLine(this.line); // ensure that the exception contains current line of source code
        }
    }

    public List<Integer> compile(Scanner input) throws AssemblerInstructionException {
        while (input.hasNextLine()) {
            this.compileLine(input.nextLine());
            line++;
        }

        return this.result;
    }


}
