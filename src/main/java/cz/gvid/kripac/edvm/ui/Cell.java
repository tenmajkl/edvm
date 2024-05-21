/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cz.gvid.kripac.edvm.ui;

import java.awt.Color;

/**
 *
 * @author majkel
 */
public class Cell extends javax.swing.JPanel {

    /**
     * Creates new form Cell
     */
    public Cell() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        value = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.GridBagLayout());

        value.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        value.setText("0");
        jPanel1.add(value, new java.awt.GridBagConstraints());

        id.setText("0:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public Cell setId(int id) {
        this.id.setText(id + ":");
        return this;
    }
    
    public Cell setValue(int value) {
        this.value.setText(value + "");
        return this;
    }
    
    public Cell highlight() {
        this.setBackground(Color.red);
        return this;
    }
    
    public Cell clear()  {
        this.setBackground(Color.DARK_GRAY);
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel value;
    // End of variables declaration//GEN-END:variables
}
