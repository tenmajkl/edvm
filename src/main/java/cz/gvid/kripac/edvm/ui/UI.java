/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cz.gvid.kripac.edvm.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.File;

/**
 *
 * @author majkel
 */
public class UI extends javax.swing.JFrame {

    private FileSelector fs;
    
    /**
     * Creates new form UI
     */
    public UI() {
        FlatDarkLaf.setup();
        initComponents();
        this.mainPanel.add(fs = new FileSelector(this));
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("edvm");
        setMinimumSize(new java.awt.Dimension(800, 450));
        setSize(new java.awt.Dimension(800, 450));
        getContentPane().setLayout(new java.awt.GridBagLayout());
        getContentPane().add(mainPanel, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void runSimulator(File file) {
        this.remove(fs);
        this.add(new Simulator(file));
        validate();
        repaint();
        pack();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
