package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Not
 */
public class Not implements Instruction {
    private int register; 

    public Not(int register) {
        this.register = register;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException{
        registers.put(
                register, 
                registers.get(register) == 0 
                ? 1 
                : 0
        );
    }

    public int getRegister() {
        return register;
    }
}
