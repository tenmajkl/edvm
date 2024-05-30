package cz.gvid.kripac.edvm.ui.machine;

import cz.gvid.kripac.edvm.ui.Simulator;
import cz.gvid.kripac.edvm.ui.contracts.Tapeable;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Simulator implementation for GUI
 */
public class SimulatorRegisters implements cz.gvid.kripac.edvm.vm.contracts.Registers, Tapeable {

    private int[] tape = new int[16];
    
    private Simulator simulator;

    public SimulatorRegisters(Simulator simulator) {
        this.simulator = simulator;
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int get(int address) throws VMRuntimeException {
        if (address > 16) {
            throw new VMRuntimeException("Address out of bounds! Register " + address + " does not exist.");
        }
        
        simulator.getRegistersTape().highlightRead(address);

        return tape[address];
    }
  
    /**
     * {@inheritDoc}
     */
    @Override
    public SimulatorRegisters put(int address, int value) throws VMRuntimeException {
        if (address > 16) {
            throw new VMRuntimeException("Address out of bounds! Register " + address + " does not exist.");
        }

        value = value % 256; // integer overflow

        if (value < 0) {
            tape[address] = 256 + value; // integer underflow
            return this;
        }

        tape[address] = value;
        
        simulator.getRegistersTape().highlightWrite(address);
        
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getValue(int address) {
        return tape[address];
    }
}
