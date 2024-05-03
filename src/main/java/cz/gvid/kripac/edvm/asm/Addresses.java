package cz.gvid.kripac.edvm.asm;

import java.util.HashMap;

/**
 * Holds all named addresses by their tag
 */
public class Addresses {

    private HashMap<String, Integer> addresses = new HashMap<String, Integer>();

    /**
     * Returns instruction id (address) of given tag 
     * @param tag input tag name 
     * @return address 
     */
    public int getAddress(String tag) {
        return this.addresses.get(tag);
    }

    /**
     * Adds new address with given name 
     * @param tag name of address 
     * @param address 
     * @return self
     */
    public Addresses setAddress(String tag, int address) {
        this.addresses.put(tag, address);
        return this;
    }

    /**
     * Determines whenever there is and address for given tag name
     * @param tag
     * @return
     */
    public boolean hasAddress(String tag) {
        return this.addresses.get(tag) != null;
    }
}
