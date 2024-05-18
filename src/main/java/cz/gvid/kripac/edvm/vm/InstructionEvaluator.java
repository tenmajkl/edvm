package cz.gvid.kripac.edvm.vm;

import java.util.List;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * InstructionEvaluator
 */
public class InstructionEvaluator {

    private List<Instruction> instructions;

    private InstructionPointer pointer;

    private Memory memory;
    private Registers registers;
    private System system;

    public InstructionEvaluator(List<Instruction> instructions, Memory memory, Registers registers, System system) {
        this.instructions = instructions;
        this.memory = memory;
        this.registers = registers;
        this.system = system;
        this.pointer = new InstructionPointer(instructions.size());
    }

    /**
     * Goes to next instruction and evaluates it.
     *
     * @throws VMRuntimeException
     */
    public void evalNext() throws VMRuntimeException {
        this.pointer.next();
        this.instructions.get(pointer.getPointer()).eval(this.memory, this.registers, this.system, pointer);
    }

    /**
     * Determines whenever there is instruction that can be evaluated.
     */
    public boolean canEvalNext() {
        return pointer.canGoNext();
    }
    
    public int getPointer() {
        return pointer.getPointer();
    }


}
