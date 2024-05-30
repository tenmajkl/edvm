/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.asm;

import cz.gvid.kripac.edvm.asm.contracts.Argument;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author majkel
 */
public class Instruction {
    private String name;
    private int id;
    private List<Argument> arguments;
    
    public Instruction(String name, int id, List<Argument> arguments) {
        this.name = name;
        this.id = id;
        this.arguments = arguments;
    }
    
    public int compile(List<String> arguments, Addresses addresses) throws AssemblerInstructionException {

        var result = new ArrayList<Integer>();

        var pattern = new ArrayList<Integer>();

        int index = 0;
        try {
            for (; index < this.arguments.size(); index++) {
                result.add(
                        this.arguments.get(index).compile(arguments.get(index + 1), addresses)
                );
                pattern.add(this.arguments.get(index).getSize());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AssemblerInstructionException("Missing argument " + index);
        }
        return BytecodeGenerator.convert(id, result, pattern);
    }
}
