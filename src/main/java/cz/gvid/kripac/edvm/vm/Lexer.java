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

    private final int STATE_S = 0;
    private final int STATE_A = 1;
    
    /**
     * Reads input stream into list of integer instruction representation
     *
     * @param in stream that will be read
     * @return list of integer instruction representations 
     * @throws InstructionException if the instruction does not continue
    */
    public ArrayList<Integer> lex(InputStream in) throws InstructionException {
        int curent = 0;
        int buffer = 0;
        var result = new ArrayList<Integer>();
        int state = STATE_S;
        
        try {
            while ((curent = in.read()) != -1) {                
                switch (state) {
                    case STATE_S:
                        buffer = curent;
                        state = STATE_A;
                        break;
                    case STATE_A:
                        result.add((buffer << 8) + curent);
                        state = STATE_S;
                        break;
                }
            }
            
            if (state != STATE_S) {
                throw new InstructionException("Instruction is not complete!");           
            }
        } catch(IOException e) {
            throw new InstructionException(e.getMessage());
        }

        return result;
    }
}
