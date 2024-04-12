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
    }

    public void evalNext() throws VMRuntimeException {
        this.instructions.get(pointer.getPointer()).eval(this.memory, this.registers, this.system, pointer);
        this.pointer.next();
    }

    public boolean canEvalNext() {
        return pointer.canGoNext();
    }
}
