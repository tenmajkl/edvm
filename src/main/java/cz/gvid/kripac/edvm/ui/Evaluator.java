/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.ui;

import cz.gvid.kripac.edvm.vm.InstructionEvaluator;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import java.util.List;
import java.util.Map;

/**
 * Evaluator wrap around graphical simulator
 * 
 * @author majkel
 */
public class Evaluator {
    
    private Map<Integer, String> asm;
    private Map<Integer, String> tags;
    private InstructionEvaluator instructions;
    private List<Integer> bytecode;
    private Simulator simulator;
    
    public Evaluator(Map<Integer, String> asm, Map<Integer, String> tags, InstructionEvaluator instructions, List<Integer> bytecode, Simulator simulator) {
        this.asm = asm;
        this.tags = tags;
        this.instructions = instructions;
        this.bytecode = bytecode;
        this.simulator = simulator;
    }
    
    public String getCode(int current) {
        String result = "";
        for (int line = 0; line < asm.size(); line++) {
            if (tags.containsKey(line - 1)) {
                result += "  " + tags.get(line - 1) + "\n";
            }
            result += (line == current ? "> " : "  ") + asm.get(line) + "\n";
        }
        
        return result;
    }
    
    public String getByteCode(int current) {
        String result = "";
        for (int line = 0; line < bytecode.size(); line++) {
            if (tags.containsKey(line - 1)) {
                result += "\n";
            }
            result += (line == current ? "> " : "  ") + String.format(
                    "%16s", 
                    Integer.toBinaryString(bytecode.get(line))
            ).replace(" ","0") + "\n";
        }
        
        return result;  
    }
    
    public void next() throws VMRuntimeException {
        if (!instructions.canEvalNext()) {
            return;
        }
        
        instructions.evalNext();
        simulator.getCode().setText(getCode(instructions.getPointer()));
        simulator.getBytecode().setText(getByteCode(instructions.getPointer()));
    }
}
