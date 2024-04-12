package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Instruction
 */
public interface Instruction {
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException; 
}
