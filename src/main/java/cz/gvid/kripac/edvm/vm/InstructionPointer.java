package cz.gvid.kripac.edvm.vm;

/**
 * InstructionPointer
 * Represents address of currently executed instruction
 * Can be modified -> jumps
 * Basicaly just boxed integer
 */
public class InstructionPointer {
    private int pointer = 0;

    public InstructionPointer setPointer(int pointer) {
        this.pointer = pointer;
        return this;
    }

    public InstructionPointer next() {
        pointer++;
        return this;
    }

    public int getPointer() {
        return pointer;
    }
}
