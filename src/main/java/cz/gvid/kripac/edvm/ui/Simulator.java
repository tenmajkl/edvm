/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cz.gvid.kripac.edvm.ui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author majkel
 */
public class Simulator extends javax.swing.JPanel {

    private File file;
    
    /**
     * Creates new form Simulator
     */
    public Simulator(File input) {
        initComponents();
        file = input;
        try {
            code.setText(Files.readString(file.toPath()));
        } catch (IOException e) {
        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        code = new javax.swing.JEditorPane();

        setBackground(new java.awt.Color(40, 40, 40));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(146, 131, 116)));

        code.setBorder(null);
        code.setFont(new java.awt.Font("Source Code Pro Light", 0, 13)); // NOI18N
        code.setCaretColor(new java.awt.Color(146, 131, 116));
        code.setFocusTraversalPolicyProvider(true);
        code.setPreferredSize(new java.awt.Dimension(500, 250));
        code.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(code);
        code.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane code;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
