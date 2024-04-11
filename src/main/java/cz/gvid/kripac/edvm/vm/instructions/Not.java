package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;

/**
 * Not
 */
public class Not implements Instruction {
    private int register; 

    public Not(int register) {
        this.register = register;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, Integer instruction_address) {
        // TODO Auto-generated method stub
        
    }

    public int getRegister() {
        return register;
    }
}
