package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Div
 */
public class Div implements Instruction {
    private int xReg;
    private int yReg;
    private int resultReg; 

    public Div(int xReg, int yReg, int resultReg) {
        this.xReg = xReg;
        this.yReg = yReg;
        this.resultReg = resultReg;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException {
        try {
            registers.put(
                   resultReg,
                   registers.get(xReg) / registers.get(yReg)
            );
        } catch (ArithmeticException e) {
            throw new VMRuntimeException(e.getMessage());
        }
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
