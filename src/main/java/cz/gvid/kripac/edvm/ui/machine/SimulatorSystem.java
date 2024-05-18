/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.ui.machine;

import cz.gvid.kripac.edvm.vm.contracts.System;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author majkel
 */
public class SimulatorSystem implements System {

    private JTextArea console;
    
    public SimulatorSystem(JTextArea console) {
        this.console = console;
    }
    
    @Override
    public int call(int id, int in) throws VMRuntimeException {
        // TODO remove switch
        switch (id) {
            case 0b0000:
                console.setText(console.getText() + in);
                return 0;

            case 0b0001:
                console.setText(console.getText() + (char) in);
                return 0;

//            case 0b0010:
//                try {
//                    return java.lang.System.in.read();
//                } catch (IOException e) {
//                    throw new VMRuntimeException(e.getMessage());
//                }
        }
        throw new VMRuntimeException("Unknown syscall");
    }
    
}
