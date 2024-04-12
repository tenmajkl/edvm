/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cz.gvid.kripac.edvm;

import java.io.FileInputStream;
import java.io.IOException;

import cz.gvid.kripac.edvm.vm.VM;

/**
 *
 * @author kripac 
 */
public class Edvm {

    public static void main(String[] args) {
        try (var file = new FileInputStream("test.esm")) {
            var vm = new VM(file);
            vm.execute();
        } catch (IOException e) {
            System.out.println("Error while openning input file!");
        }
    }
}
