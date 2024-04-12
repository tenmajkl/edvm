package cz.gvid.kripac.edvm.vm;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * InstructionPointer
 * Represents address of currently executed instruction
 * Can be modified -> jumps
 * Basicaly just boxed integer
 */
public class InstructionPointer {
    private int pointer = 0;
    private final int limit = 255;

    public InstructionPointer setPointer(int pointer) throws VMRuntimeException {
        if (pointer > limit) {
            throw new VMRuntimeException("Instruction out of bounds! Unable to jump to instruction " + pointer + ".");
        }
        this.pointer = pointer;
        return this;
    }

    public InstructionPointer next() throws VMRuntimeException {
        pointer++;
        if (pointer > limit) {
            throw new VMRuntimeException("Instruction out of bounds! Unable to go to the next instruction.");
        }
        return this;
    }

    public boolean canGoNext() {
        return pointer <= limit;
    }

    public int getPointer() {
        return pointer;
    }
}
