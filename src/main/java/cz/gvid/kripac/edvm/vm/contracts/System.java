package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * System
 */
public interface System {
    /*** 
     * Calls system-call with given ID.
     * @param id of the call 
     * @param in input data
     * @param out output register address
     * @return output of the call
     * @throws VMRuntimeException
     */
    public int call(int id, int in, int out) throws VMRuntimeException;
}
