package cz.gvid.kripac.edvm.asm;

import java.util.HashMap;

/**
 * Holds all named addresses by their tag
 */
public class Addresses {

    private HashMap<String, Integer> addresses;

    public int getAddress(String tag) {
        return this.addresses.get(tag);
    }

    public Addresses setAddress(String tag, int address) {
        this.addresses.put(tag, address);
        return this;
    }

    public boolean hasAddress(String tag) {
        return this.addresses.get(tag) != null;
    }
}
