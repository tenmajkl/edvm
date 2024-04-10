package cz.gvid.kripac.edvm.vm.contracts;

/**
 * Instruction
 */
public interface Instruction {
    public void eval(Memory memory, Registers registers, System system, Integer instruction_address); 
}
