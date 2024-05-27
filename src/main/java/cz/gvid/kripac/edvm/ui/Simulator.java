/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cz.gvid.kripac.edvm.ui;

import cz.gvid.kripac.edvm.asm.exceptions.AssemblerInstructionException;
import cz.gvid.kripac.edvm.ui.machine.SimulatorMemory;
import cz.gvid.kripac.edvm.ui.machine.SimulatorRegisters;
import cz.gvid.kripac.edvm.ui.machine.SimulatorSystem;
import cz.gvid.kripac.edvm.vm.exception.InstructionException;
import cz.gvid.kripac.edvm.vm.exception.VMRuntimeException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author majkel
 */
public class Simulator extends javax.swing.JPanel {

    private File file;
    private Evaluator evaluator;
    
    private SimulatorMemory memory;
    private SimulatorRegisters registers;
    private SimulatorSystem system;
    
    private Tape memoryTape;
    private Tape registersTape;
    
    /**
     * Creates new Simulator panel
     */
    public Simulator(File input) {
        initComponents();
        
        file = input;
        memory = new SimulatorMemory(this);
        registers = new SimulatorRegisters(this);
        system = new SimulatorSystem(this);
        
        memoryTape = new Tape(memory, 16, 16);
        registersTape = new Tape(registers, 4, 4);
        memoryPanel.add(memoryTape);
        registersPanel.add(registersTape);
        
        try (var in = new FileInputStream(file)){
            evaluator = new AsmCompiler().toEvaluator(in, this, 
                    memory,
                    registers,
                    system
            );
            code.setText(evaluator.getCode(-1));
            bytecode.setText(evaluator.getByteCode(-1));
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Unable to open file", JOptionPane.ERROR_MESSAGE);
        } catch (AssemblerInstructionException ex) {
            JOptionPane.showMessageDialog(this, ex.show(), "Error", JOptionPane.ERROR_MESSAGE);    
            System.exit(-1);
        } catch (InstructionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
        BoundedRangeModel model = codeScroll.getVerticalScrollBar().getModel();
        bytecodeScroll.getVerticalScrollBar().setModel( model );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        codePanel = new javax.swing.JPanel();
        codeScroll = new javax.swing.JScrollPane();
        code = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bytecodeScroll = new javax.swing.JScrollPane();
        bytecode = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        buttons = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();
        tickSpeed = new javax.swing.JSpinner();
        consoleScroll = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        registersPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        memoryPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        code.setEditable(false);
        code.setBorder(null);
        code.setContentType("text/html"); // NOI18N
        code.setFont(new java.awt.Font("Source Code Pro", 0, 13)); // NOI18N
        code.setCaretColor(new java.awt.Color(146, 131, 116));
        code.setFocusTraversalPolicyProvider(true);
        code.setPreferredSize(new java.awt.Dimension(500, 250));
        code.setRequestFocusEnabled(false);
        codeScroll.setViewportView(code);
        code.getAccessibleContext().setAccessibleName("");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Code");

        javax.swing.GroupLayout codePanelLayout = new javax.swing.GroupLayout(codePanel);
        codePanel.setLayout(codePanelLayout);
        codePanelLayout.setHorizontalGroup(
            codePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(codeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(codePanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 269, Short.MAX_VALUE))
        );
        codePanelLayout.setVerticalGroup(
            codePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(codePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(codePanel);

        bytecode.setBorder(null);
        bytecode.setContentType("text/html"); // NOI18N
        bytecode.setFont(new java.awt.Font("SauceCodePro NF", 0, 13)); // NOI18N
        bytecode.setCaretColor(new java.awt.Color(146, 131, 116));
        bytecode.setFocusTraversalPolicyProvider(true);
        bytecode.setPreferredSize(new java.awt.Dimension(500, 250));
        bytecode.setRequestFocusEnabled(false);
        bytecodeScroll.setViewportView(bytecode);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Bytecode");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bytecodeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 237, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bytecodeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel1);

        buttons.setLayout(new java.awt.GridLayout(1, 0, 10, 5));

        nextButton.setText("NEXT");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        buttons.add(nextButton);

        runButton.setText("RUN");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });
        buttons.add(runButton);

        tickSpeed.setToolTipText("Slock speed (ms)");
        tickSpeed.setAutoscrolls(true);
        tickSpeed.setValue(1000);
        tickSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tickSpeedStateChanged(evt);
            }
        });
        buttons.add(tickSpeed);

        console.setEditable(false);
        console.setColumns(20);
        console.setFont(new java.awt.Font("Source Code Pro", 0, 13)); // NOI18N
        console.setRows(5);
        console.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                consoleKeyTyped(evt);
            }
        });
        consoleScroll.setViewportView(console);

        registersPanel.setBorder(new com.formdev.flatlaf.ui.FlatBorder());
        registersPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Console");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setText("Registers");

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
            .addComponent(consoleScroll)
            .addComponent(registersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consoleScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(rightPanel);

        memoryPanel.setBorder(new com.formdev.flatlaf.ui.FlatBorder());
        memoryPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Memory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(memoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tickSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tickSpeedStateChanged
        if (timer == null) {
            return;
        }

        timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                evaluator.next();
            }
        }, (int) tickSpeed.getValue(), (int) tickSpeed.getValue());
    }//GEN-LAST:event_tickSpeedStateChanged

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        if (timer != null) {
            timer.cancel();
            timer = null;
            runButton.setText("RUN");
            return;
        }

        runButton.setText("PAUSE");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                evaluator.next();
            }
        }, (int) tickSpeed.getValue(), (int) tickSpeed.getValue());
    }//GEN-LAST:event_runButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        evaluator.next();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void consoleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consoleKeyTyped
        if (outputRegister == -1) {
            return;
        }
        
        var key = evt.getKeyChar();

        try {
            registers.put(outputRegister, (int) key);
        } catch (VMRuntimeException e) {
            // this should not happen
        }
        outputRegister = -1;
        console.setText(console.getText() + key);
    }//GEN-LAST:event_consoleKeyTyped

    private int outputRegister = -1;
    
    public void waitForKey(int outputRegister) {
        this.outputRegister = outputRegister;
    }
    
    public boolean isWaiting() {
        return outputRegister != -1;
    }
    
    private Timer timer;
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttons;
    private javax.swing.JEditorPane bytecode;
    private javax.swing.JScrollPane bytecodeScroll;
    private javax.swing.JEditorPane code;
    private javax.swing.JPanel codePanel;
    private javax.swing.JScrollPane codeScroll;
    private javax.swing.JTextArea console;
    private javax.swing.JScrollPane consoleScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel memoryPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel registersPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton runButton;
    private javax.swing.JSpinner tickSpeed;
    // End of variables declaration//GEN-END:variables

    public File getFile() {
        return file;
    }

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public JEditorPane getBytecode() {
        return bytecode;
    }

    public JEditorPane getCode() {
        return code;
    }

    public JTextArea getConsole() {
        return console;
    }

    public JButton getjButton1() {
        return nextButton;
    }

    public JPanel getjPanel1() {
        return codePanel;
    }

    public JScrollPane getjScrollPane1() {
        return codeScroll;
    }

    public JScrollPane getjScrollPane2() {
        return bytecodeScroll;
    }

    public JScrollPane getjScrollPane3() {
        return consoleScroll;
    }

    public SimulatorMemory getMemory() {
        return memory;
    }

    public SimulatorRegisters getRegisters() {
        return registers;
    }

    public SimulatorSystem getSystem() {
        return system;
    }

    public Tape getMemoryTape() {
        return memoryTape;
    }

    public Tape getRegistersTape() {
        return registersTape;
    }


}
