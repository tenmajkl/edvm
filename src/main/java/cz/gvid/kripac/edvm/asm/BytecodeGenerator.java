package cz.gvid.kripac.edvm.asm;

import java.util.List;

/**
 * Provides bytecode generation of given non-binary input
 */
public class BytecodeGenerator {
    /**
     * Converts given input into binary representation of instructio n
     * @param instruction id of instruction for vm 
     * @param arguments list of all user input arguments 
     * @param pattern pattern defining how do arguments look
     * @return binary representation
     */
    public static int convert(int instruction, List<Integer> arguments, List<Integer> pattern) {
        int result = instruction << 12;
        int shift = 12;
        for (int index = 0; index < pattern.size(); index++) {
            shift -= pattern.get(index);
            result += arguments.get(index) << shift;
        }
        return result;
    }
}
