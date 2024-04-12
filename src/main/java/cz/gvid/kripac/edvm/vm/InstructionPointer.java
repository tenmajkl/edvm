package cz.gvid.kripac.edvm.vm;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * InstructionPointer
 * Represents address of currently executed instruction
 * Can be modified -> jumps
 * Basicaly just boxed integer
 * Address = pointer in this context
 */
public class InstructionPointer {
    private int pointer = -1;
    private int limit;

    public InstructionPointer() {
        limit = 256;
    }

    public InstructionPointer(int limit) {
        this.limit = limit;
    }

    /**
     * Jumps to specific instruction by its address.
     *
     * @return self
     * @throws VMRuntimeException if the pointer is out of bounds
     */
    public InstructionPointer setPointer(int pointer) throws VMRuntimeException {
        if (pointer > limit) {
            throw new VMRuntimeException("Instruction out of bounds! Unable to jump to instruction " + pointer + ".");
        }
        this.pointer = pointer;
        return this;
    }

    /**
     * Goes to the next instruction.
     *
     * @return self
     * @throws VMRuntimeException if the pointer is out of range
     */
    public InstructionPointer next() throws VMRuntimeException {
        pointer++;
        if (pointer > limit) {
            throw new VMRuntimeException("Instruction out of bounds! Unable to go to the next instruction.");
        }
        return this;
    }

    /**
     * Determines whenever its possible to go to the next instruction.
     */
    public boolean canGoNext() {
        return pointer + 1 < limit;
    }

    /**
     * Returns address of current instruction.
     */
    public int getPointer() {
        return pointer;
    }
}
