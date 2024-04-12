package cz.gvid.kripac.edvm.vm.parsers;

import java.util.Arrays;

import cz.gvid.kripac.edvm.vm.ArgumentParser;
import cz.gvid.kripac.edvm.vm.contracts.Instruction;
import cz.gvid.kripac.edvm.vm.contracts.InstructionParser;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.instructions.Jmp;

/**
 * JmpParser
 */
public class JmpParser implements InstructionParser {
    @Override
    public Instruction parse(int arguments) throws InstructionException {
        var args = ArgumentParser.parse(Arrays.asList(8), arguments);
        return new Jmp(args.get(0));
    }
}
