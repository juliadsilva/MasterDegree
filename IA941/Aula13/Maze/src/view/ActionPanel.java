/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import edu.memphis.ccrg.lida.framework.ModuleName;
import edu.memphis.ccrg.lida.framework.gui.panels.GuiPanel;
import edu.memphis.ccrg.lida.framework.gui.panels.GuiPanelImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import modules.Environment;

/**
 *
 * @author lucas
 */
public class ActionPanel extends GuiPanelImpl {
    
    private static final Logger logger = Logger.getLogger(ActionPanel.class.getCanonicalName());
    private Environment environment;

    /**
     * Creates new form ActionPanel
     */
    public ActionPanel() {
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

        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        actionLabel = new javax.swing.JLabel();
        landMarkLabel = new javax.swing.JLabel();
        AvoidWallButton = new javax.swing.JToggleButton();
        goToLandMarkButton = new javax.swing.JToggleButton();
        getButton = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Chosen Action:");

        actionLabel.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        actionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actionLabel.setText("None");

        landMarkLabel.setText("[ 0 ; 0 ]");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(landMarkLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(actionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(landMarkLabel))
        );

        AvoidWallButton.setText("Avoid Wall");

        goToLandMarkButton.setText("Go to Landmark");

        getButton.setText("Get");

        jLabel3.setText("Current LandMark  >");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goToLandMarkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AvoidWallButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(goToLandMarkButton)
                        .addGap(18, 18, 18)
                        .addComponent(AvoidWallButton)
                        .addGap(18, 18, 18)
                        .addComponent(getButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void initPanel(String[] param) {
        environment = (Environment) agent.getSubmodule(ModuleName.Environment);
        if (environment != null) {
            refresh();
        } else {
            logger.log(Level.WARNING,
                    "Unable to parse module {1} Panel not initialized.",
                    new Object[]{0L, param[0]});
        }
    }
    
        @Override
    public void refresh() {
        int lastPressedButton = environment.getLastPressedButton();
        landMarkLabel.setText("[ "+environment.landmarks.getX()+" ; "+environment.landmarks.getY()+" ]");
        switch(lastPressedButton){
            case 1:
                goToLandMarkButton.setSelected(true);
                AvoidWallButton.setSelected(false);
                getButton.setSelected(false);
                actionLabel.setText("Go to Land Mark");
                break;
            case 2:
                goToLandMarkButton.setSelected(false);
                AvoidWallButton.setSelected(true);
                getButton.setSelected(false);
                actionLabel.setText("Avoid Wall");
                break;
            case 3:
                goToLandMarkButton.setSelected(false);
                AvoidWallButton.setSelected(false);
                getButton.setSelected(true);
                actionLabel.setText("Get");
                break;
            default:
                goToLandMarkButton.setSelected(false);
                AvoidWallButton.setSelected(false);
                getButton.setSelected(false);
                actionLabel.setText("None");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AvoidWallButton;
    private javax.swing.JLabel actionLabel;
    private javax.swing.JToggleButton getButton;
    private javax.swing.JToggleButton goToLandMarkButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel landMarkLabel;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
