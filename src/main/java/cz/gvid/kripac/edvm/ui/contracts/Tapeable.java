package cz.gvid.kripac.edvm.ui.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Represents class that can be used as VM tape. 
 */
public interface Tapeable {
    /**
     * Puts given value to the given address on the tape.
     *
     * @param address address where will be the data put
     * @param value value which will be saved
     * @return self
     * @throws VMRuntimeException 
     */
    public Tapeable put(int address, int value) throws VMRuntimeException;


    /**
     * Returns value on given address on the tape.
     * 
     * @param address address from which will be the data read 
     * @return value on the address
     * @throws VMRuntimeException
     */
    public int get(int address) throws VMRuntimeException;
    
    /**
     * Returns value of given register without checking or GUI actions
     * @param address address we're accessing
     * @return value on given register address
     */
    public int getValue(int address);
}
