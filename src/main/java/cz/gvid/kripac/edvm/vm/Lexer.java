package cz.gvid.kripac.edvm.vm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;

/**
 * Lexer
 */
public class Lexer {

    /**
     * Reads input stream into list of integer instruction representation
     *
     * @param in stream that will be read
     * @return list of integer instruction representations 
     * @throws InstructionException if the instruction does not continue
    */
    public ArrayList<Integer> lex(InputStream in) throws InstructionException {
        int curent = 0;
        var result = new ArrayList<Integer>();
        try {
            while ((curent = in.read()) != -1) {
                int rest = in.read();
                if (rest == -1) {
                    throw new InstructionException("Instruction is not complete!");
                }
                result.add((curent << 8) + rest);
            }
        } catch(IOException e) {
            throw new InstructionException(e.getMessage());
        }

        return result;
    }
}
