package cz.gvid.kripac.edvm;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Scanner;
//
//import cz.gvid.kripac.edvm.asm.Compiler;
//import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;
//import cz.gvid.kripac.edvm.vm.VM;

import cz.gvid.kripac.edvm.ui.UI;

/**
 *
 * @author kripac 
 */
public class Edvm {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });

//        try (var input = new Scanner(new FileReader("test_2.esm"))) {
//            var compiler = new Compiler();
//            var instructions = compiler.compile(input);
//            new VM(instructions).execute();
//        } catch (FileNotFoundException e) {
//
//        } catch (AssemblerInstructionException e) {
//
//        }
    }
}
