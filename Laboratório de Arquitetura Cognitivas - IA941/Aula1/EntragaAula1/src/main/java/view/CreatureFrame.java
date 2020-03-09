/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import util.Constants;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;
import ws3dproxy.model.World;
import ws3dproxy.model.WorldPoint;

import static ws3dproxy.util.Constants.M_PI;
/**
 *
 * @author lucas
 */
public class CreatureFrame extends javax.swing.JFrame {
    
    WS3DProxy proxy = null;
    World world = null;
    Map<String,String> creaturesCreated = new HashMap<String,String>();
    Creature selectedCreature= null;
    
    
    /**
     * Creates new form CreatureFrame
     */
    public CreatureFrame(WS3DProxy proxy, World world) {
        this.proxy = proxy;
        this.world = world;
        initComponents();
        addCreaturesToComboBox(selectCreatureComboBox);
    }
    
    private void addCreaturesToComboBox( JComboBox<String> comboBox ){
        comboBox.removeAllItems();
        creaturesCreated.entrySet().forEach((pair) -> comboBox.addItem(pair.getValue()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newCreaturePanel = new javax.swing.JPanel();
        creatureColorComboBox = new javax.swing.JComboBox<>();
        creatureColorLabel = new javax.swing.JLabel();
        creatureXPositionLabel = new javax.swing.JLabel();
        creatureYPositionLabel = new javax.swing.JLabel();
        creatureXPositionTextField = new javax.swing.JTextField();
        creatureYPositionTextField = new javax.swing.JTextField();
        createCreatureButton = new javax.swing.JButton();
        pitchSlider = new javax.swing.JSlider();
        pitchLabel = new javax.swing.JLabel();
        zeroLabel = new javax.swing.JLabel();
        thsLabel = new javax.swing.JLabel();
        updateCreaturePanel = new javax.swing.JPanel();
        updateCreatureLabel = new javax.swing.JLabel();
        selectCreatureComboBox = new javax.swing.JComboBox<>();
        moveCreaturePanel = new javax.swing.JPanel();
        moveUpButton = new javax.swing.JButton();
        clockwiseRotationButton = new javax.swing.JButton();
        moveDownButton = new javax.swing.JButton();
        antiClockwiseRotationButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creature");
        setAlwaysOnTop(true);

        newCreaturePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Creature", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        creatureColorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yellow", "Red" }));

        creatureColorLabel.setText("Color");

        creatureXPositionLabel.setText("X position ");

        creatureYPositionLabel.setText("Y position");

        creatureXPositionTextField.setText("0");

        creatureYPositionTextField.setText("0");

        createCreatureButton.setText("Create Creature");
        createCreatureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCreatureButtonActionPerformed(evt);
            }
        });

        pitchSlider.setMaximum(360);
        pitchSlider.setValue(0);

        pitchLabel.setText("Pitch");

        zeroLabel.setText("0º");

        thsLabel.setText("360º");

        javax.swing.GroupLayout newCreaturePanelLayout = new javax.swing.GroupLayout(newCreaturePanel);
        newCreaturePanel.setLayout(newCreaturePanelLayout);
        newCreaturePanelLayout.setHorizontalGroup(
            newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCreaturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newCreaturePanelLayout.createSequentialGroup()
                        .addComponent(pitchLabel)
                        .addGap(38, 38, 38)
                        .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(newCreaturePanelLayout.createSequentialGroup()
                                .addComponent(zeroLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(thsLabel))
                            .addComponent(createCreatureButton, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(pitchSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(newCreaturePanelLayout.createSequentialGroup()
                        .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creatureXPositionLabel)
                            .addComponent(creatureYPositionLabel)
                            .addComponent(creatureColorLabel))
                        .addGap(4, 4, 4)
                        .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(creatureColorComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 159, Short.MAX_VALUE)
                            .addComponent(creatureXPositionTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creatureYPositionTextField, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newCreaturePanelLayout.setVerticalGroup(
            newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCreaturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newCreaturePanelLayout.createSequentialGroup()
                        .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(creatureColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creatureColorLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(creatureXPositionLabel)
                            .addComponent(creatureXPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(creatureYPositionLabel)
                            .addComponent(creatureYPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pitchSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pitchLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zeroLabel)
                    .addComponent(thsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createCreatureButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        updateCreaturePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Creature", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        updateCreatureLabel.setText("Creature");

        selectCreatureComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCreatureComboBoxActionPerformed(evt);
            }
        });

        moveCreaturePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Move", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        moveUpButton.setIcon(new javax.swing.ImageIcon("/home/lucas/Área de Trabalho/Codes/MasterDegree/Laboratório de Arquitetura Cognitivas - IA941/Aula1/EntragaAula1/Resources/upArrow.png")); // NOI18N
        moveUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                moveUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                moveUpButtonMouseReleased(evt);
            }
        });

        clockwiseRotationButton.setIcon(new javax.swing.ImageIcon("/home/lucas/Área de Trabalho/Codes/MasterDegree/Laboratório de Arquitetura Cognitivas - IA941/Aula1/EntragaAula1/Resources/rightRotation.png")); // NOI18N
        clockwiseRotationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clockwiseRotationButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clockwiseRotationButtonMouseReleased(evt);
            }
        });

        moveDownButton.setIcon(new javax.swing.ImageIcon("/home/lucas/Área de Trabalho/Codes/MasterDegree/Laboratório de Arquitetura Cognitivas - IA941/Aula1/EntragaAula1/Resources/downArrow.png")); // NOI18N
        moveDownButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                moveDownButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                moveDownButtonMouseReleased(evt);
            }
        });

        antiClockwiseRotationButton.setIcon(new javax.swing.ImageIcon("/home/lucas/Área de Trabalho/Codes/MasterDegree/Laboratório de Arquitetura Cognitivas - IA941/Aula1/EntragaAula1/Resources/leftRotation.png")); // NOI18N
        antiClockwiseRotationButton.setToolTipText("");
        antiClockwiseRotationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                antiClockwiseRotationButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                antiClockwiseRotationButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout moveCreaturePanelLayout = new javax.swing.GroupLayout(moveCreaturePanel);
        moveCreaturePanel.setLayout(moveCreaturePanelLayout);
        moveCreaturePanelLayout.setHorizontalGroup(
            moveCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moveCreaturePanelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(moveCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(moveUpButton)
                    .addGroup(moveCreaturePanelLayout.createSequentialGroup()
                        .addComponent(antiClockwiseRotationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveDownButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clockwiseRotationButton)
                .addGap(38, 38, 38))
        );
        moveCreaturePanelLayout.setVerticalGroup(
            moveCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moveCreaturePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moveUpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moveCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(antiClockwiseRotationButton)
                    .addComponent(moveDownButton)
                    .addComponent(clockwiseRotationButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout updateCreaturePanelLayout = new javax.swing.GroupLayout(updateCreaturePanel);
        updateCreaturePanel.setLayout(updateCreaturePanelLayout);
        updateCreaturePanelLayout.setHorizontalGroup(
            updateCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCreaturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moveCreaturePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(updateCreaturePanelLayout.createSequentialGroup()
                        .addComponent(updateCreatureLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectCreatureComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        updateCreaturePanelLayout.setVerticalGroup(
            updateCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCreaturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateCreaturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCreatureLabel)
                    .addComponent(selectCreatureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveCreaturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newCreaturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateCreaturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newCreaturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateCreaturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createCreatureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCreatureButtonActionPerformed
        try {
            int xPosition = Integer.parseInt(creatureXPositionTextField.getText());
            int yPosition = Integer.parseInt(creatureYPositionTextField.getText());
            
            int color = creatureColorComboBox.getSelectedIndex();
            int pitch = pitchSlider.getValue();
            Creature creature = this.proxy.createCreature(xPosition, yPosition, pitch, color);
            creaturesCreated.put(creature.getIndex(), creature.getName());
            selectCreatureComboBox.addItem(creature.getName());
            JOptionPane.showMessageDialog(this, "Creature created with name: "+creature.getName());    
        } catch (CommandExecException ex) {
            Logger.getLogger(CreatureFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Failed to create a creature!");
        }
    }//GEN-LAST:event_createCreatureButtonActionPerformed

    private void antiClockwiseRotationButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_antiClockwiseRotationButtonMouseReleased
        stopSelectedCreature();
    }//GEN-LAST:event_antiClockwiseRotationButtonMouseReleased

    private void antiClockwiseRotationButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_antiClockwiseRotationButtonMousePressed
        try {
            selectedCreature.rotate(-Constants.CREATURE_VELOCITY);
            selectedCreature.start();
        } catch (CommandExecException ex) {
            Logger.getLogger(CreatureFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_antiClockwiseRotationButtonMousePressed

    private void moveDownButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveDownButtonMouseReleased
        stopSelectedCreature();
    }//GEN-LAST:event_moveDownButtonMouseReleased

    private void moveDownButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveDownButtonMousePressed
        try {
            selectedCreature.move(-Constants.CREATURE_VELOCITY, -Constants.CREATURE_VELOCITY, 0);
            selectedCreature.start();
        } catch (CommandExecException ex) {
            Logger.getLogger(CreatureFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_moveDownButtonMousePressed

    private void clockwiseRotationButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clockwiseRotationButtonMouseReleased
        stopSelectedCreature();
    }//GEN-LAST:event_clockwiseRotationButtonMouseReleased

    private void clockwiseRotationButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clockwiseRotationButtonMousePressed
        try {
            selectedCreature.rotate(Constants.CREATURE_VELOCITY);
            selectedCreature.start();
        } catch (CommandExecException ex) {
            Logger.getLogger(CreatureFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_clockwiseRotationButtonMousePressed

    private void moveUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveUpButtonMouseReleased
        stopSelectedCreature();
    }//GEN-LAST:event_moveUpButtonMouseReleased

    private void moveUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveUpButtonMousePressed
        try {
            selectedCreature.move(Constants.CREATURE_VELOCITY, Constants.CREATURE_VELOCITY, 0);
            selectedCreature.start();
        } catch (CommandExecException ex) {
            Logger.getLogger(CreatureFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_moveUpButtonMousePressed

    private void selectCreatureComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCreatureComboBoxActionPerformed
        try {
            selectedCreature = proxy.getCreature(Integer.toString(selectCreatureComboBox.getSelectedIndex()));
            selectedCreature.start();
        } catch (CommandExecException ex) {
            JOptionPane.showMessageDialog(this, "Falied to select creature!");
            Logger.getLogger(CreatureFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_selectCreatureComboBoxActionPerformed

    private void stopSelectedCreature(){
        try{ 
            selectedCreature.stop();
            System.out.println(selectedCreature.getPitch());
        } catch (CommandExecException ex) {
            Logger.getLogger(CreatureFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton antiClockwiseRotationButton;
    private javax.swing.JButton clockwiseRotationButton;
    private javax.swing.JButton createCreatureButton;
    private javax.swing.JComboBox<String> creatureColorComboBox;
    private javax.swing.JLabel creatureColorLabel;
    private javax.swing.JLabel creatureXPositionLabel;
    private javax.swing.JTextField creatureXPositionTextField;
    private javax.swing.JLabel creatureYPositionLabel;
    private javax.swing.JTextField creatureYPositionTextField;
    private javax.swing.JPanel moveCreaturePanel;
    private javax.swing.JButton moveDownButton;
    private javax.swing.JButton moveUpButton;
    private javax.swing.JPanel newCreaturePanel;
    private javax.swing.JLabel pitchLabel;
    private javax.swing.JSlider pitchSlider;
    private javax.swing.JComboBox<String> selectCreatureComboBox;
    private javax.swing.JLabel thsLabel;
    private javax.swing.JLabel updateCreatureLabel;
    private javax.swing.JPanel updateCreaturePanel;
    private javax.swing.JLabel zeroLabel;
    // End of variables declaration//GEN-END:variables
}
