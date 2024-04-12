package cz.gvid.kripac.edvm.vm.contracts;

import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * System
 */
public interface System {
    public int out(char value) throws VMRuntimeException;

    public int in() throws VMRuntimeException;
}
