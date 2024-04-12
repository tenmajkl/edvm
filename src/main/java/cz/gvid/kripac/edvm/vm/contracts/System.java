package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * System
 */
public interface System {
    public int call(int id, int in) throws VMRuntimeException;
}
