/*
 * The MIT License
 *
 * Copyright 2015 John Fish <john@johnafish.ca>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package automatamusic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.UIManager;

/**
 *
 * @author John Fish <john@johnafish.ca>
 */
public class AutomataMusic extends javax.swing.JFrame {
    private int tempo = 120;
    private int numFrames = 45;
    public static int automatonSize = 16;
    public int[][] board = getRandomArray(automatonSize, automatonSize);
    public int[][] score = new int[numFrames][8];
    public String chosenSim = "Game of Life";
    public boolean animating = false;
    public int frameNo = 0;
    public Thread playThread;
    /**
     * Creates new form ScreenView
     */
    public AutomataMusic() {
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

        jColorChooser1 = new javax.swing.JColorChooser();
        title = new javax.swing.JLabel();
        tempoSlider = new javax.swing.JSlider();
        tempoLabel = new javax.swing.JLabel();
        tempoValue = new javax.swing.JLabel();
        instrumentLabel = new javax.swing.JLabel();
        pianoCheckBox = new javax.swing.JCheckBox();
        snareCheckBox = new javax.swing.JCheckBox();
        guitarCheckBox = new javax.swing.JCheckBox();
        bellCheckBox = new javax.swing.JCheckBox();
        otherCheckBox = new javax.swing.JCheckBox();
        otherInstrumentTextField = new javax.swing.JTextField();
        visualizationLabel = new javax.swing.JLabel();
        visualizationChoice = new javax.swing.JComboBox();
        stopButton = new javax.swing.JButton();
        volumeValue = new javax.swing.JLabel();
        frameSlider = new javax.swing.JSlider();
        volumeLabel = new javax.swing.JLabel();
        randomizeButton = new javax.swing.JButton();
        visualizationPanel = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setName("MainScreen"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(640, 360));

        title.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        title.setText("Cellular Music");

        tempoSlider.setMaximum(240);
        tempoSlider.setMinimum(40);
        tempoSlider.setMinorTickSpacing(20);
        tempoSlider.setPaintLabels(true);
        tempoSlider.setPaintTicks(true);
        tempoSlider.setValue(120);
        tempoSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tempoSliderStateChanged(evt);
            }
        });

        tempoLabel.setText("Tempo");

        tempoValue.setText("120");

        instrumentLabel.setText("Instruments");

        pianoCheckBox.setSelected(true);
        pianoCheckBox.setLabel("Piano");
        pianoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pianoCheckBoxActionPerformed(evt);
            }
        });

        snareCheckBox.setText("Snare Drum");
        snareCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snareCheckBoxActionPerformed(evt);
            }
        });

        guitarCheckBox.setText("Electric Guitar");
        guitarCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guitarCheckBoxActionPerformed(evt);
            }
        });

        bellCheckBox.setText("Bell");
        bellCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bellCheckBoxActionPerformed(evt);
            }
        });

        otherCheckBox.setText("Other");

        otherInstrumentTextField.setText("74");
        otherInstrumentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherInstrumentTextFieldActionPerformed(evt);
            }
        });

        visualizationLabel.setText("Simulation");

        visualizationChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Game of Life", "Reaction Diffusion", "Static" }));
        visualizationChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizationChoiceActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        volumeValue.setText("45");

        frameSlider.setMaximum(200);
        frameSlider.setMinimum(1);
        frameSlider.setMinorTickSpacing(25);
        frameSlider.setPaintLabels(true);
        frameSlider.setPaintTicks(true);
        frameSlider.setValue(45);
        frameSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frameSliderStateChanged(evt);
            }
        });

        volumeLabel.setText("Number of Frames");

        randomizeButton.setText("Randomize");
        randomizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeButtonActionPerformed(evt);
            }
        });

        visualizationPanel.setBackground(new java.awt.Color(255, 255, 255));
        visualizationPanel.setPreferredSize(new java.awt.Dimension(675, 120));

        javax.swing.GroupLayout visualizationPanelLayout = new javax.swing.GroupLayout(visualizationPanel);
        visualizationPanel.setLayout(visualizationPanelLayout);
        visualizationPanelLayout.setHorizontalGroup(
            visualizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        visualizationPanelLayout.setVerticalGroup(
            visualizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(instrumentLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(snareCheckBox)
                                            .addComponent(pianoCheckBox))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(guitarCheckBox)
                                            .addComponent(bellCheckBox)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(otherCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(otherInstrumentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(visualizationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(visualizationLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(playButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(stopButton))
                                    .addComponent(randomizeButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(415, 415, 415)
                                        .addComponent(volumeValue))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tempoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tempoLabel)
                                            .addComponent(frameSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(volumeLabel))
                                        .addGap(18, 18, 18)
                                        .addComponent(tempoValue))))
                            .addComponent(visualizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instrumentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(tempoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tempoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tempoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(volumeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(volumeValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(frameSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pianoCheckBox)
                            .addComponent(guitarCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(snareCheckBox)
                            .addComponent(bellCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(otherCheckBox)
                            .addComponent(otherInstrumentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visualizationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visualizationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(randomizeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playButton)
                            .addComponent(stopButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pianoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pianoCheckBoxActionPerformed
  
    }//GEN-LAST:event_pianoCheckBoxActionPerformed

    private void guitarCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guitarCheckBoxActionPerformed

    }//GEN-LAST:event_guitarCheckBoxActionPerformed

    private void snareCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snareCheckBoxActionPerformed

    }//GEN-LAST:event_snareCheckBoxActionPerformed

    private void tempoSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tempoSliderStateChanged
        this.tempo = tempoSlider.getValue();
        tempoValue.setText(Integer.toString(this.tempo));
    }//GEN-LAST:event_tempoSliderStateChanged

    private void otherInstrumentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherInstrumentTextFieldActionPerformed

    }//GEN-LAST:event_otherInstrumentTextFieldActionPerformed

    private void bellCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bellCheckBoxActionPerformed
        {
        }    }//GEN-LAST:event_bellCheckBoxActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        playThread.interrupt();
        this.animating=false;
    }//GEN-LAST:event_stopButtonActionPerformed

    private void frameSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frameSliderStateChanged
        volumeValue.setText(Integer.toString(frameSlider.getValue()));
        this.numFrames = frameSlider.getValue();
        this.score = new int[this.numFrames][8];
        this.generateFrames();
    }//GEN-LAST:event_frameSliderStateChanged

    private void randomizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeButtonActionPerformed
        if(!animating){
            this.board = getRandomArray(automatonSize, automatonSize);
            this.generateFrames();
        }
    }//GEN-LAST:event_randomizeButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        playThread = new Thread(new MIDIPlayer(tempo,score));
        playThread.start();
        this.animating = true;
    }//GEN-LAST:event_playButtonActionPerformed

    private void visualizationChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizationChoiceActionPerformed
        this.chosenSim = visualizationChoice.getSelectedItem().toString();
        this.generateFrames();
    }//GEN-LAST:event_visualizationChoiceActionPerformed
    
    public static void sleep(int millis) throws InterruptedException{
        Thread.sleep(millis);
    }
    
    public static int[][] getRandomArray(int width, int height){
        int board[][] = new int[width][height];
        Random rand = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = rand.nextInt(2)*255;
            }
        }
        return board;
    }
    
    public static int[] boxify(int numBoxes, int[] arr){
        int arrayLength = arr.length;
        int[] finalArray = new int[numBoxes];
        int step = arrayLength/numBoxes;

        for (int i = 0; i < numBoxes; i++) {
            int steps = 0;
            for (int j = i*step; j < (i+1)*step; j++) {
                finalArray[i]+=arr[j];
                steps++;
            }
            finalArray[i]/=steps;
        }
        return finalArray;
    }
    public static int[] collapse(int[][] arr){
        int[] returnable = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int column = 0;
            for (int j = 0; j < arr.length; j++) {
                column+=arr[i][j];
            }
            returnable[i] = column/arr.length;
        }
        return returnable;
    }
    
    public static BufferedImage arrayToImage(int[][] array){
        BufferedImage img = new BufferedImage(array.length, array[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int gray = 255-array[i][j];
                Color col = new Color(gray,gray,gray);
                img.setRGB(i, j, col.getRGB());
            }
        }
        return img;
    }
    
    public static BufferedImage scale(BufferedImage image, int scalingFactor){
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scalingFactor, scalingFactor);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return bilinearScaleOp.filter(
            image,
            new BufferedImage(image.getWidth()*scalingFactor, image.getHeight()*scalingFactor, image.getType()));
    }
    
    
    public void nextFrame(int i){
        Graphics g = visualizationPanel.getGraphics();
        BufferedImage img = arrayToImage(score);
        Color gray = new Color(238,238,238);
        g.setColor(gray);
        g.fillRect(0, 0, 675, 120);
        g.drawImage(scale(img,15), -15*i, 0, rootPane);
    }
    
    public void generateFrames(){
        this.frameNo = 0;
        CellularAutomaton gl;
        if (chosenSim.equalsIgnoreCase("Game of Life")){
            gl = new GOL();
        } else if (chosenSim.equalsIgnoreCase("Reaction Diffusion")){
            gl = new ReactionDiffusion();
        } else {
            gl = new Static();
        }
        
        this.board = gl.initializeFrame();
        for (int i = 0; i < numFrames; i++) {
            
            int[] collapsed = collapse(this.board);
            int[] boxed = boxify(8,collapsed);
            score[i] = boxed;
            this.board = gl.nextFrame();
            
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            System.out.println(e);
        }
        
        AutomataMusic sv = new AutomataMusic();
        sv.generateFrames();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sv.setVisible(true);
            }
        });
        while(true){
            sv.nextFrame(sv.frameNo);
            if(sv.animating){
                sv.randomizeButton.setEnabled(false);
                sv.tempoSlider.setEnabled(false);
                sv.visualizationChoice.setEnabled(false);
                sv.frameNo++;
            } else {
                sv.randomizeButton.setEnabled(true);
                sv.tempoSlider.setEnabled(true);
                sv.visualizationChoice.setEnabled(true);
                sv.frameNo = 0;
            }
            if(sv.frameNo==sv.numFrames){
                sv.animating = false;
            }
            try{
                Thread.sleep(60000/sv.tempo);
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bellCheckBox;
    private javax.swing.JSlider frameSlider;
    private javax.swing.JCheckBox guitarCheckBox;
    private javax.swing.JLabel instrumentLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JCheckBox otherCheckBox;
    private javax.swing.JTextField otherInstrumentTextField;
    private javax.swing.JCheckBox pianoCheckBox;
    private javax.swing.JButton playButton;
    private javax.swing.JButton randomizeButton;
    private javax.swing.JCheckBox snareCheckBox;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel tempoLabel;
    private javax.swing.JSlider tempoSlider;
    private javax.swing.JLabel tempoValue;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox visualizationChoice;
    private javax.swing.JLabel visualizationLabel;
    private javax.swing.JPanel visualizationPanel;
    private javax.swing.JLabel volumeLabel;
    private javax.swing.JLabel volumeValue;
    // End of variables declaration//GEN-END:variables
}
