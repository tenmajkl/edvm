package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Instruction
 */
public interface Instruction {
    /**
     * Runs the instruction.
     *
     * @param memory for storing data
     * @param registers for storing data in registers
     * @param system for syscalls
     * @param pointer current code position
     * @throws VMRuntimeException
    */
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException; 
}
