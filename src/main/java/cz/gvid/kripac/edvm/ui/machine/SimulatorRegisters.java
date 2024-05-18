/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.ui.machine;

import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 *
 * @author majkel
 */
public class SimulatorRegisters implements Registers {

    private int[] registers = new int[16];

    /**
     * {@inheritDoc}
     */
    @Override
    public int get(int address) throws VMRuntimeException {
        if (address > 16) {
            throw new VMRuntimeException("Address out of bounds! Register " + address + " does not exist.");
        }

        return registers[address];
    }
  
    /**
     * {@inheritDoc}
     */
    @Override
    public Registers put(int address, int value) throws VMRuntimeException {
        if (address > 16) {
            throw new VMRuntimeException("Address out of bounds! Register " + address + " does not exist.");
        }

        value = value % 256; // integer overflow

        if (value < 0) {
            this.registers[address] = 256 + value; // integer underflow
            return this;
        }

        this.registers[address] = value;
        return this;
    }
}
