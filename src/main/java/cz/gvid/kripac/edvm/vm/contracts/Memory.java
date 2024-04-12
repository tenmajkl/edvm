package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Memory
 */
public interface Memory {

    public Memory put(int address, int value) throws VMRuntimeException;

    public int get(int address) throws VMRuntimeException;
}
