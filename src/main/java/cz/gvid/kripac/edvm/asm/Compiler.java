package cz.gvid.kripac.edvm.asm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import cz.gvid.kripac.edvm.asm.arguments.Address;
import cz.gvid.kripac.edvm.asm.arguments.Numeric;
import cz.gvid.kripac.edvm.asm.contracts.Argument;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;

public class Compiler {
    private HashMap<String, List<Argument>> instructions = new HashMap<String, List<Argument>>();
    private Addresses addresses = new Addresses();
    private int line = 0;
    private ArrayList<Integer> result = new ArrayList<Integer>();

    public Compiler() {
        instructions.put("srv", Arrays.asList(new Numeric(4), new Numeric(8)));
        instructions.put("add", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("sub", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("mul", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("div", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("or", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("not", Arrays.asList(new Numeric(4)));
        instructions.put("and", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("jmp", Arrays.asList(new Address()));
        instructions.put("jzr", Arrays.asList(new Numeric(4), new Address()));
        instructions.put("set", Arrays.asList(new Numeric(8), new Numeric(4)));
        instructions.put("get", Arrays.asList(new Numeric(8), new Numeric(4)));
        instructions.put("sys", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("equ", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("gt", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));
        instructions.put("st", Arrays.asList(new Numeric(4), new Numeric(4), new Numeric(4)));

    }

    /**
     * Tries to compile line with address
     * @param line
     * @return
     */
    public boolean compileAddress(String line) {
        var pattern = Pattern.compile("^\\s*([a-zA-Z0-9]+):\\s*$");
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
    public void compileInstruction(String line) throws AssemblerInstructionException {
        var tokens = line.split("\\s+");
        List<Argument> args;
        if ((args = this.instructions.get(tokens[0])) == null) {
            throw new AssemblerInstructionException("Unknown instruction " + tokens[0]);
        }

        var result = new ArrayList<Integer>();

        for (int index = 0; index < args.size(); index++) {
            result.add(
                    args.get(index).compile(tokens[index + 1], this.addresses)
            );
        }
    }


}
