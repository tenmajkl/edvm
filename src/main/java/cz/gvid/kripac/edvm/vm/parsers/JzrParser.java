package cz.gvid.kripac.edvm.vm.parsers;

import java.util.Arrays;

import cz.gvid.kripac.edvm.vm.ArgumentParser;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.InstructionParser;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.Jzr;

/**
 * JzrParser
 */
public class JzrParser implements InstructionParser {
    @Override
    public Instruction parse(int arguments) throws InstructionException {
        var args = ArgumentParser.parse(Arrays.asList(4, 8), arguments);
        return new Jzr(args.get(0), args.get(1));
    } 
}
