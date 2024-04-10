package cz.gvid.kripac.edvm.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * ArgumentParser
 */
public class ArgumentParser {

    public static List<Integer> parse(List<Integer> arguments, int target) {
        var result = new ArrayList<Integer>();
        int input_size = 12; // expecting that input is 12 bits by default
        for (int size : arguments) {
            input_size -= size;
            result.add(target >> input_size); // get the first n digits
            target &= (int) (Math.pow(2, input_size) - 1); // remove first n digits -- creates and uses mask
        }

        return result;
    }
}
