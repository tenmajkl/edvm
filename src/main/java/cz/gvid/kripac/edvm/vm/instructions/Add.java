package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Add
 */
public class Add implements Instruction {
    private int xReg;
    private int yReg; 
    private int resultReg;

    public Add(int xReg, int yReg, int resultReg) {
        this.xReg = xReg;
        this.yReg = yReg;
        this.resultReg = resultReg;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException {
        registers.put(
               resultReg,
               memory.get(registers.get(xReg)) + memory.get(registers.get(yReg))
        ); 
    }

    public int getxReg() {
        return xReg;
    }

    public int getyReg() {
        return yReg;
    }

    public int getResultReg() {
        return resultReg;
    }
}
