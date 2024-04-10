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

    public Instructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void eval(Memory memory, Registers registers, System system) {
        Integer current = 0;
        while (current < this.instructions.size()) {
            this.instructions.get(current.intValue()).eval(memory, registers, system, current);;
        }
    }
}
