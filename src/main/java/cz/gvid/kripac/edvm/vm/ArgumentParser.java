package cz.gvid.kripac.edvm.vm;

import java.util.ArrayList;
import java.util.List;

import cz.gvid.kripac.edvm.vm.exception.InstructionException;

/**
 * ArgumentParser
 */
public class ArgumentParser {

    public static List<Integer> parse(List<Integer> arguments, int target) throws InstructionException {
        var result = new ArrayList<Integer>();
        int input_size = 12; // expecting that input is 12 bits by default
        int argument_id = 0;
        for (int size : arguments) {
            input_size -= size;
            if (input_size < 0) {
                throw new InstructionException("Error at parsing argument " + argument_id);
            }
            // TODO check too small instructions?
            result.add(target >> input_size); // get the first n digits
            target &= (int) (Math.pow(2, input_size) - 1); // remove first n digits -- creates and uses mask
            argument_id++;
        }

        return result;
    }
}
