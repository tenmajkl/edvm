/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gvid.kripac.edvm.ui;

import cz.gvid.kripac.edvm.vm.InstructionEvaluator;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author majkel
 */
public class Evaluator {
    
    private Evaluator(List<String> asm, InstructionEvaluator bytecode) {
    
    }
    
    public static Evaluator fromStream(InputStream in) {
        var scanner = new Scanner(in);
        
    }
}
