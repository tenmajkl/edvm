package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Memory
 */
public interface Memory {
    /**
     * Puts given value to the given address on the tape.
     *
     * @param address address where will be the data put
     * @param value value which will be saved
     * @return self
     * @throws VMRuntimeException 
     */
    public Memory put(int address, int value) throws VMRuntimeException;


    /**
     * Returns value on given address on the tape.
     * 
     * @param address address from which will be the data read 
     * @return value on the address
     * @throws VMRuntimeException
     */
    public int get(int address) throws VMRuntimeException;
}
