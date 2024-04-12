package cz.gvid.kripac.edvm.vm.machine;

import java.io.IOException;

import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * MachineSystem
 */
public class MachineSystem implements System {
    /**
     * {@inheritDoc}
     */
    @Override
    public int call(int id, int in) throws VMRuntimeException {
        // TODO remove switch
        switch (id) {
            case 0b0000:
                java.lang.System.out.print(in);
                return 0;

            case 0b0001:
                java.lang.System.out.print((char) in);
                return 0;

            case 0b0010:
                try {
                    return java.lang.System.in.read();
                } catch (IOException e) {
                    throw new VMRuntimeException(e.getMessage());
                }
        }
        throw new VMRuntimeException("Unknown syscall");
    }
}
