package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;

/**
 * Equ
 */
public class Equ implements Instruction {
    private int xReg; 
    private int yReg;
    private int resultReg;

    public Equ(int xReg, int yReg, int resultReg) {
        this.xReg = xReg;
        this.yReg = yReg;
        this.resultReg = resultReg;
    }

    @Override
    public void eval(Memory memory, Registers registers, System system, Integer instruction_address) {
        // TODO Auto-generated method stub
        
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
