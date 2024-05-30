package cz.gvid.kripac.edvm.ui;

import cz.gvid.kripac.edvm.asm.Compiler;
import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;
import cz.gvid.kripac.edvm.ui.machine.SimulatorMemory;
import cz.gvid.kripac.edvm.ui.machine.SimulatorRegisters;
import cz.gvid.kripac.edvm.ui.machine.SimulatorSystem;
import cz.gvid.kripac.edvm.vm.InstructionEvaluator;
import cz.gvid.kripac.edvm.vm.Parser;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Wrap around default ASM compiler allowing us to generate inputs for Evaluator
 */
public class AsmCompiler extends Compiler {

    /**
     * Compiles given input file into evaluator.
     *
     * @param input stream of asm 
     * @param simulator ui instance  
     * @param memory memory instance for ui 
     * @param registers registers instance for ui 
     * @param system system isntance for ui 
     * @return new evaluator instance
     * @throws AssemblerInstructionException if there is a compiler error 
     * @throws InstructionException when there is an error while parsing compiled bytecode (should not happen)
     */
    public Evaluator toEvaluator(InputStream input, Simulator simulator, SimulatorMemory memory, SimulatorRegisters registers, SimulatorSystem system) throws AssemblerInstructionException, InstructionException  {
        var scanner = new Scanner(input);
        var asm = new HashMap<Integer, String>();
        var tags = new HashMap<Integer, String>();
        String line;
        
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (this.compileTag(line)) {          
                tags.put(this.line, line);
            } else {
                this.compileInstruction(line);                
                asm.put(this.line, line);
            }
            this.line++;
        }
        
        var parser = new Parser();
        scanner.close();
        return new Evaluator(
                asm, 
                tags,
                new InstructionEvaluator(
                    parser.parse(this.result),
                    memory,
                    registers,
                    system
                ),
                this.result,
                simulator
        );
    }
}
