package cz.gvid.kripac.edvm.vm.parsers;

import java.util.Arrays;

import cz.gvid.kripac.edvm.vm.ArgumentParser;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.InstructionParser;
import cz.gvid.kripac.edvm.vm.instructions.Not;

/**
 * NotParser
 */
public class NotParser implements InstructionParser {
    @Override
    public Instruction parse(int arguments) {
        var args = ArgumentParser.parse(Arrays.asList(4), arguments);
        return new Not(args.get(0));
    }
}
