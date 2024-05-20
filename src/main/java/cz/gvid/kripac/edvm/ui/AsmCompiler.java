/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author majkel
 */
public class AsmCompiler extends Compiler {
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
