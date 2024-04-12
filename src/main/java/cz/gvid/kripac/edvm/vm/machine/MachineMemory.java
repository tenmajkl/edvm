package cz.gvid.kripac.edvm.vm.machine;

import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Memory implementation for standalone VM.
 */
public class MachineMemory implements Memory {

    private int[] tape = new int[256];

    /**
     * {@inheritDoc}
     */
    @Override
    public int get(int address) throws VMRuntimeException {
        if (address > 255) {
            throw new VMRuntimeException("Address out of bounds! Memory tape has 256 cells, cell " + address + " could not be reached.");
        }
        return tape[address];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Memory put(int address, int value) throws VMRuntimeException {
        if (address > 255) {
            throw new VMRuntimeException("Address out of bounds! Memory tape has 256 cells, cell " + address + " could not be reached.");
        }

        value = value % 256; // integer overflow

        if (value < 0) {
            this.tape[address] = 256 + value; // integer underflow
            return this;
        }

        this.tape[address] = value; 

        return this;
    }
}
