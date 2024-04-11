package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;

/**
 * Jmp
 */
public class Jmp implements Instruction{
    private int instruction; 

    public Jmp(int instruction) {
        this.instruction = instruction;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, Integer instruction_address) {
        // TODO Auto-generated method stub
        
    }
    
    public int getInstruction() {
        return instruction;
    }

}
