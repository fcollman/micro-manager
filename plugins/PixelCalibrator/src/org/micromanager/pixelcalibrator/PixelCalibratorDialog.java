/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PixelCalibratorDialog.java
 *
 * Created on Mar 1, 2010, 10:21:50 AM
 */

package org.micromanager.pixelcalibrator;

import java.lang.reflect.InvocationTargetException;
import org.micromanager.MMStudio;
import org.micromanager.utils.GUIUtils;
import org.micromanager.utils.ReportingUtils;

/**
 *
 * @author arthur
 */
public class PixelCalibratorDialog extends javax.swing.JFrame {
   private PixelCalibratorPlugin plugin_;


    /** Creates new form PixelCalibratorDialog */
   PixelCalibratorDialog(PixelCalibratorPlugin plugin) {
      plugin_ = plugin;
      initComponents();
      GUIUtils.recallPosition(this);
             
      setBackground(MMStudio.getInstance().getBackgroundColor());
      MMStudio.getInstance().addMMBackgroundListener(this);
   }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPopupMenu1 = new javax.swing.JPopupMenu();
      jPopupMenu2 = new javax.swing.JPopupMenu();
      explanationLabel = new javax.swing.JLabel();
      calibrationProgressBar = new javax.swing.JProgressBar();
      startButton = new javax.swing.JButton();
      stopButton = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      safeTravelRadiusComboBox = new javax.swing.JComboBox();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Pixel Calibrator");
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent evt) {
            formWindowClosing(evt);
         }
      });

      explanationLabel.setText("<html>This plugin automatically measures size of the default camera's pixels at the sample plane.<br><br>To calibrate:<br><ol><li>Make sure you are using a correctly calibrated motorized xy stage.</li><li>Choose a nonperiodic specimen (e.g., a cell) and adjust your illumination and focus until you obtain crisp, high-contrast images. <li>Press Start (below).</li></ol></html>");

      calibrationProgressBar.setForeground(new java.awt.Color(255, 0, 51));

      startButton.setText("Start");
      startButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            startButtonActionPerformed(evt);
         }
      });

      stopButton.setText("Stop");
      stopButton.setEnabled(false);
      stopButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            stopButtonActionPerformed(evt);
         }
      });

      jLabel1.setText("Safe travel radius, um:");

      safeTravelRadiusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1000", "10000", "100000" }));
      safeTravelRadiusComboBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            safeTravelRadiusComboBoxActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(explanationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(31, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(24, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(70, 70, 70)
                  .addComponent(stopButton))
               .addComponent(startButton)
               .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(calibrationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(safeTravelRadiusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(31, 31, 31))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(explanationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(safeTravelRadiusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(stopButton)
                  .addComponent(startButton))
               .addComponent(calibrationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );

      setSize(new java.awt.Dimension(414, 328));
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
       plugin_.stopCalibration();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
       plugin_.startCalibration();
    }//GEN-LAST:event_startButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       plugin_.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void safeTravelRadiusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_safeTravelRadiusComboBoxActionPerformed
       plugin_.safeTravelRadiusUm_ = Double.parseDouble(safeTravelRadiusComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_safeTravelRadiusComboBoxActionPerformed

    public void updateStatus(final boolean running, final double progress) {
      try {
         GUIUtils.invokeLater(new Runnable() {
            public void run() {
               if (!running) {
                  startButton.setEnabled(true);
                  stopButton.setEnabled(false);
                  calibrationProgressBar.setEnabled(false);
                  safeTravelRadiusComboBox.setEnabled(true);
               } else {
                  toFront();
                  startButton.setEnabled(false);
                  stopButton.setEnabled(true);
                  calibrationProgressBar.setEnabled(true);
                  safeTravelRadiusComboBox.setEnabled(false);
               }
               calibrationProgressBar.setValue((int) (progress*100));
            }
         });
      } catch (InterruptedException ex) {
         ReportingUtils.logError(ex);
      } catch (InvocationTargetException ex) {
         ReportingUtils.logError(ex);
      }
       //this.repaint();
    }
    

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JProgressBar calibrationProgressBar;
   private javax.swing.JLabel explanationLabel;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPopupMenu jPopupMenu1;
   private javax.swing.JPopupMenu jPopupMenu2;
   private javax.swing.JComboBox safeTravelRadiusComboBox;
   private javax.swing.JButton startButton;
   private javax.swing.JButton stopButton;
   // End of variables declaration//GEN-END:variables

   public void dispose() {
      super.dispose();
   }
   
   public void setPlugin(PixelCalibratorPlugin plugin) {
      plugin_ = plugin;
   }


}
