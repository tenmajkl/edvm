package cz.gvid.kripac.edvm.vm.instructions;

import cz.gvid.kripac.edvm.vm.InstructionPointer;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 * Sys
 */
public class Sys implements Instruction {
    private int id;
    private int inputReg; 
    private int outputReg;

    public Sys(int id, int inputReg, int outputReg) {
        this.id = id; 
        this.inputReg = inputReg;
        this.outputReg = outputReg;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eval(Memory memory, Registers registers, System system, InstructionPointer pointer) throws VMRuntimeException {
        registers.put(
                outputReg, 
                system.call(id, registers.get(inputReg))
        );
    }

    public int getId() {
        return id;
    }

    public int getInputReg() {
        return inputReg;
    }

    public int getOutputReg() {
        return outputReg;
    }

}
