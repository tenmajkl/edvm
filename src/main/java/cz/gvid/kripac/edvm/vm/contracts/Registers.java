package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Registers
 */
public interface Registers {

    public Registers put(int address, int value) throws VMRuntimeException;

    public int get(int address) throws VMRuntimeException;
}
