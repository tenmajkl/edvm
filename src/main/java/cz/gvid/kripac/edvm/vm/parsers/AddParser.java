package cz.gvid.kripac.edvm.vm.parsers;

import java.util.Arrays;

import cz.gvid.kripac.edvm.vm.ArgumentParser;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.InstructionParser;
import cz.gvid.kripac.edvm.vm.instructions.Add;

/**
 * AddParser
 */
public class AddParser implements InstructionParser {
    @Override
    public Instruction parse(int arguments) {
        var args = ArgumentParser.parse(Arrays.asList(4, 4, 4), arguments);
        return new Add(args.get(0), args.get(1), args.get(2));
    }
}
