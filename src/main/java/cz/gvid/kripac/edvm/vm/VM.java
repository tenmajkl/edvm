package cz.gvid.kripac.edvm.vm;

import java.io.InputStream;
import java.util.List;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import cz.gvid.kripac.edvm.vm.machine.MachineMemory;
import cz.gvid.kripac.edvm.vm.machine.MachineRegisters;
import cz.gvid.kripac.edvm.vm.machine.MachineSystem;

/**
 * VM
 * This class allows using this VM by itself as an actual VM accepting bytecode.
 */
public class VM {

    private InputStream stream;
    private MachineMemory memory = new MachineMemory();
    private MachineRegisters registers = new MachineRegisters();
    private MachineSystem system = new MachineSystem();

    public VM(InputStream stream) {
        this.stream = stream;
    }

    /**
     * Executes virtual machine
     * @return void
     */
    public void execute() {
        try {
            InstructionEvaluator instructions = new InstructionEvaluator(
                    new Parser().parse(new Lexer().lex(stream)),
                    memory,
                    registers, 
                    system
                );
            while (instructions.canEvalNext()) {
                instructions.evalNext();
            }
        } catch (InstructionException e) { 
            System.out.println(e.getMessage());
        } catch (VMRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
