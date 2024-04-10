package cz.gvid.kripac.edvm.vm.contracts;

/**
 * Registers
 */
public interface Registers {

    public Registers put(int address, int value);

    public int get(int address);
}
