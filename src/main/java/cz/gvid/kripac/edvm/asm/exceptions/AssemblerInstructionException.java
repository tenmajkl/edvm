package cz.gvid.kripac.edvm.asm.exceptions;

public class AssemblerInstructionException extends Exception {

    private int line = 0;

    public AssemblerInstructionException(String message) {
        super(message);
    }

    public AssemblerInstructionException(String message, int line) {
        super(message);
        this.line = line;
    }

    public int getLine() {
        return this.line;
    }

    public AssemblerInstructionException setLine(int line) {
        this.line = line;
        return this;
    }
}
