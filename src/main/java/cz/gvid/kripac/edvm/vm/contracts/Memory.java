package cz.gvid.kripac.edvm.vm.contracts;

/**
 * Memory
 */
public interface Memory {

    public Memory put(int address, int value);

    public int get(int address);
}
