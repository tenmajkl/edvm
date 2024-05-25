/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.ui.machine;

import cz.gvid.kripac.edvm.ui.Simulator;
import cz.gvid.kripac.edvm.ui.contracts.Tapeable;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 *
 * @author majkel
 */
public class SimulatorMemory implements cz.gvid.kripac.edvm.vm.contracts.Memory, Tapeable {

    private int[] tape = new int[256];

    private Simulator simulator;
    
    public SimulatorMemory(Simulator simulator) {
        this.simulator = simulator;
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int get(int address) throws VMRuntimeException {
        if (address > 255) {
            throw new VMRuntimeException("Address out of bounds! Memory tape has 256 cells, cell " + address + " could not be reached.");
        }
        
        simulator.getMemoryTape().highlightRead(address);
        
        return tape[address];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulatorMemory put(int address, int value) throws VMRuntimeException {
        if (address > 255) {
            throw new VMRuntimeException("Address out of bounds! Memory tape has 256 cells, cell " + address + " could not be reached.");
        }

        value = value % 256; // integer overflow

        if (value < 0) {
            this.tape[address] = 256 + value; // integer underflow
            return this;
        }

        this.tape[address] = value; 
        
        simulator.getMemoryTape().highlightWrite(address);
        
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getValue(int address) {
        return tape[address];
    }
}