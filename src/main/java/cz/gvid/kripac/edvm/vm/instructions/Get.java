package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Get
 */
public class Get implements Instruction {
    private int address; 
    private int register;

    public Get(int address, int register) {
        this.address = address;
        this.register = register;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, Integer instruction_address) throws VMRuntimeException {
        registers.put(register, memory.get(address));
    } 
    
    public int getAddress() {
        return address;
    }

    public int getRegister() {
        return register;
    }

}
