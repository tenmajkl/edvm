package cz.gvid.kripac.edvm.vm;

import java.util.ArrayList;

import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.Memory;
import cz.gvid.kripac.edvm.vm.contracts.Registers;
import cz.gvid.kripac.edvm.vm.contracts.System;

/**
 * Instructions
 */
public class Instructions {

    private ArrayList<Instruction> instructions;

    private Integer current = 0;

    private Memory memory;
    private Registers registers;
    private System system;

    public Instructions(ArrayList<Instruction> instructions, Memory memory, Registers registers, System system) {
        this.instructions = instructions;
        this.memory = memory;
        this.registers = registers;
        this.system = system;
    }

    public void evalNext() {
        this.instructions.get(current.intValue()).eval(this.memory, this.registers, this.system, this.current);
    }
}
