package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Jmp
 */
public class Jmp implements Instruction{
    private int instruction; 

    public Jmp(int instruction) {
        this.instruction = instruction;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException {
        pointer.setPointer(instruction - 1); // has to be -1 because when we go to next instruction, it increments it by 1 
                                             // see InstructionEvaluator
    }
    
    public int getInstruction() {
        return instruction;
    }

}
