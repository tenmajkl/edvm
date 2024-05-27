package cz.gvid.kripac.edvm.vm.exception;

/**
 * InstructionException
 * Represents exception thrown while parsing instructions.
 */
public class InstructionException extends Exception {

    public InstructionException(String message) {
        super(message);
    }
}
