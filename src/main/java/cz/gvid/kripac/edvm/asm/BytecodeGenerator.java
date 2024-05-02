package cz.gvid.kripac.edvm.asm;

import java.util.List;

public class BytecodeGenerator {
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
