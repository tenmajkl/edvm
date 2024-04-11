package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;

/**
 * Jzr
 */
public class Jzr implements Instruction {
    private int register;
    private int instruction; 

    public Jzr(int register, int instruction) {
        this.register = register; 
        this.instruction = instruction;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, Integer instruction_address) {
        // TODO Auto-generated method stub
        
    }
    
    public int getRegister() {
        return register;
    }

    public int getInstruction() {
        return instruction;
    }

}
