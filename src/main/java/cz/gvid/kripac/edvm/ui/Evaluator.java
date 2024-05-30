package cz.gvid.kripac.edvm.ui;

import cz.gvid.kripac.edvm.vm.InstructionEvaluator;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import java.util.List;
import java.util.Map;

/**
 * Evaluator wrap around graphical simulator
 */
public class Evaluator {
    
    private List<String> asm;
    private Map<Integer, String> tags;
    private InstructionEvaluator instructions;
    private List<Integer> bytecode;
    private Simulator simulator;
    private int errorAt = -1;
    
    public Evaluator(List<String> asm, Map<Integer, String> tags, InstructionEvaluator instructions, List<Integer> bytecode, Simulator simulator) {
        this.asm = asm;
        this.tags = tags;
        this.instructions = instructions;
        this.bytecode = bytecode;
        this.simulator = simulator;
    }
   
    /**
     * Returns text of ASM code that can be shown in simulator.
     * @param current line of code which is highlighted
     * @return ASM code
     */
    public String getCode(int current) {
        String result = "";
        for (int line = 0; line < asm.size(); line++) {
            if (tags.containsKey(line - 1)) {
                result += "&nbsp;&nbsp;" + tags.get(line - 1) + "<br>";
            }
            
            var text = (line == current ? "> " : "&nbsp;&nbsp;") + asm.get(line);          
            
            if (line == errorAt) {
                text = "<span style=\"color: red;\">" + text + "</span>";
            }
            
            result += text + "<br>";
        }
        
        return result;
    }
   
    /**
     * Returns text of binary code that can be shown in simulator. 
     * @param current line of code which is highlighted
     * @return binary code
     */
    public String getByteCode(int current) {
        String result = "";
        for (int line = 0; line < bytecode.size(); line++) {
            if (tags.containsKey(line - 1)) {
                result += "<br>";
            }
            var text = (line == current ? "> " : "&nbsp;&nbsp;") + String.format(
                    "%16s", 
                    Integer.toBinaryString(bytecode.get(line))
                    ).replace(" ","0");
            
            if (line == errorAt) {
                text = "<span style=\"color: red;\">" + text + "</span>";
            }
            
            result += text + "<br>";
        }
        
        return result;  
    }
   
    /**
     * Evaluates next instruction.
     */
    public void next() {
        if (!instructions.canEvalNext()) {
            return;
        }
        
        if (simulator.isWaiting()) {
            return;
        }
        
        simulator.getMemoryTape().update();
        simulator.getRegistersTape().update();
        
        try {
            instructions.evalNext();
        } catch (VMRuntimeException e) {
            errorAt = instructions.getPointer();
            simulator.getConsole().setText(
                    simulator.getConsole().getText()
                    + "\n" + e.getMessage()
            );
        }
        simulator.getCode().setText(getCode(instructions.getPointer()));
        simulator.getBytecode().setText(getByteCode(instructions.getPointer()));
    }
}
