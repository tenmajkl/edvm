/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.ui.machine;

import cz.gvid.kripac.edvm.ui.Simulator;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;

/**
 *
 * @author majkel
 */
public class SimulatorSystem implements cz.gvid.kripac.edvm.vm.contracts.System {

    private Simulator simulator;
    
    public SimulatorSystem(Simulator simulator) {
        this.simulator = simulator;
    }
    
    @Override
    public int call(int id, int in, int out) throws VMRuntimeException {
        // TODO remove switch
        switch (id) {
            case 0b0000:
                simulator.getConsole()
                         .setText(simulator.getConsole().getText() + in);
                return 0;

            case 0b0001:
                simulator.getConsole()
                         .setText(simulator.getConsole().getText() + (char) in);
                return 0;

            case 0b0010:
                simulator.waitForKey(out);
                return 0;
        }
        throw new VMRuntimeException("Unknown syscall");
    }
    
}
