package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;

/**
 * Srv
 */
public class Srv implements Instruction {

    private int register;
    private int value;

    public Srv(int register, int value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, Integer instruction_address) {
        
    } 
}
