/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.ui.machine;

import cz.gvid.kripac.edvm.ui.Memory;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 *
 * @author majkel
 */
public class SimulatorMemory implements cz.gvid.kripac.edvm.vm.contracts.Memory {

    private int[] tape = new int[256];

    private Memory memory;
    
    public SimulatorMemory(Memory memory) {
        this.memory = memory;
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int get(int address) throws VMRuntimeException {
        if (address > 255) {
            throw new VMRuntimeException("Address out of bounds! Memory tape has 256 cells, cell " + address + " could not be reached.");
        }
        this.memory.highlightCell(address);
        return tape[address];
    }
    
    /**
     * Returns value of given cell without highligting and checking if the value 
     * makes sence
     * 
     * @param address on tape
     * @return value at tape position
     */
    public int getValue(int address) {
        return tape[address];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public cz.gvid.kripac.edvm.vm.contracts.Memory put(int address, int value) throws VMRuntimeException {
        if (address > 255) {
            throw new VMRuntimeException("Address out of bounds! Memory tape has 256 cells, cell " + address + " could not be reached.");
        }

        value = value % 256; // integer overflow

        if (value < 0) {
            this.tape[address] = 256 + value; // integer underflow
            return this;
        }

        this.tape[address] = value; 
        
        this.memory.highlightCell(address);
        return this;
    }
}