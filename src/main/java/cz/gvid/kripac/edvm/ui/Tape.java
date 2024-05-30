package cz.gvid.kripac.edvm.ui;

import cz.gvid.kripac.edvm.ui.contracts.Tapeable;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Generic tape panel 
 */
public class Tape extends javax.swing.JPanel {
    
    private ArrayList<Cell> tapeCells = new ArrayList<Cell>();
    private int page = 0;
    
    private final Tapeable tape;
    private final int pages;
    private final int size;
    
    /**
     * Creates new form Memory
     */
    public Tape(Tapeable tape, int pages, int size) {
        this.tape = tape;
        this.pages = pages;
        this.size = size;
        
        initComponents();
        for (int i = 0; i < size; i++) {
            var cell = new Cell();
            cell.setId(i);
            tapeCells.add(cell);
            cells.add(cell);
        }
        left.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        left = new javax.swing.JButton();
        cells = new javax.swing.JPanel();
        right = new javax.swing.JButton();

        left.setText("<");
        left.setBorder(null);
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        cells.setPreferredSize(new java.awt.Dimension(90, 114));
        cells.setLayout(new java.awt.GridLayout());

        right.setText(">");
        right.setBorder(null);
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(left)
                .addGap(0, 0, 0)
                .addComponent(cells, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(right))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftActionPerformed
        page--;
        update();
    }//GEN-LAST:event_leftActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        page++;
        update();
    }//GEN-LAST:event_rightActionPerformed

    public void update() {
       
        right.setEnabled(page != pages - 1);

        left.setEnabled(page != 0);
        
        for (int i = 0; i < size; i++) {
            var cell = tapeCells.get(i);
            var addr = page * pages + i;
            cell.clear()
                .setId(addr)
                .setValue(tape.getValue(addr))
            ;
        }
    }
    
    private void highlightCell(int cell, Color color) {
        page = (int) Math.ceil(((double) cell + 1) / pages) - 1;
        update();
        tapeCells.get(cell - (page) * pages).highlight(color).setValue(tape.getValue(cell));
    }
    
    public void highlightRead(int cell) {
        highlightCell(cell, Color.BLUE);
    }
    
    public void highlightWrite(int cell) {
        highlightCell(cell, Color.RED);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cells;
    private javax.swing.JButton left;
    private javax.swing.JButton right;
    // End of variables declaration//GEN-END:variables
}
