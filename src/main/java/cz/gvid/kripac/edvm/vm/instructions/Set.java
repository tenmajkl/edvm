package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Set
 */
public class Set implements Instruction {
    private int address;
    private int register;
    
    public Set(int address, int register) {
        this.address = address;
        this.register = register;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException {
       memory.put(registers.get(address), registers.get(register));
    } 

    public int getAddress() {
        return address;
    }

    public int getRegister() {
        return register;
    }

}
