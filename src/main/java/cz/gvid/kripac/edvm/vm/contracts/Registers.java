package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Registers
 */
public interface Registers {
  
    /***
     * Puts value to given register address.
     *
     * @param address where will be the value saved
     * @param value which will be saved 
     * @return self
     * @throws VMRuntimeException
     */
    public Registers put(int address, int value) throws VMRuntimeException;

    /**
     * Returns value from given register address
     *
     * @param address which will be read
     * @return data on given address 
     * @throws VMRuntimeException
     */
    public int get(int address) throws VMRuntimeException;
}
