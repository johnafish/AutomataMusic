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
    private MIDIPlayer md = new MIDIPlayer();
    public int[][] board = getRandomArray(automatonSize, automatonSize);
    public int[][] score = new int[numFrames][8];
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
        generateButton = new javax.swing.JButton();
        volumeValue = new javax.swing.JLabel();
        volumeSlider = new javax.swing.JSlider();
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

        visualizationChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Game of Life", "Reaction Diffusion", "Pollution Simulation" }));

        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        volumeValue.setText("75");

        volumeSlider.setMinorTickSpacing(25);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setValue(75);
        volumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeSliderStateChanged(evt);
            }
        });

        volumeLabel.setText("Volume");

        randomizeButton.setText("Randomize");
        randomizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeButtonActionPerformed(evt);
            }
        });

        visualizationPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout visualizationPanelLayout = new javax.swing.GroupLayout(visualizationPanel);
        visualizationPanel.setLayout(visualizationPanelLayout);
        visualizationPanelLayout.setHorizontalGroup(
            visualizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
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
                                    .addComponent(playButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(415, 415, 415)
                                        .addComponent(volumeValue))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tempoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tempoLabel)
                                            .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(volumeLabel))
                                        .addGap(18, 18, 18)
                                        .addComponent(tempoValue))))
                            .addComponent(visualizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(randomizeButton))))
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
                            .addComponent(volumeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(randomizeButton)
                            .addComponent(generateButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(playButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pianoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pianoCheckBoxActionPerformed
        if (md.isActive(0)){
            md.removeInstrument(0);
        } else {
            md.addInstrument(0);
        }
        
    }//GEN-LAST:event_pianoCheckBoxActionPerformed

    private void guitarCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guitarCheckBoxActionPerformed
        if (md.isActive(25)){
            md.removeInstrument(25);
        } else {
            md.addInstrument(25);
        }
    }//GEN-LAST:event_guitarCheckBoxActionPerformed

    private void snareCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snareCheckBoxActionPerformed
        if (md.isActive(10)){
            md.removeInstrument(10);
        } else {
            md.addInstrument(10);
        }
    }//GEN-LAST:event_snareCheckBoxActionPerformed

    private void tempoSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tempoSliderStateChanged
        this.tempo = tempoSlider.getValue();
        md.setTempo(tempo);
        tempoValue.setText(Integer.toString(tempo));
    }//GEN-LAST:event_tempoSliderStateChanged

    private void otherInstrumentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherInstrumentTextFieldActionPerformed

    }//GEN-LAST:event_otherInstrumentTextFieldActionPerformed

    private void bellCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bellCheckBoxActionPerformed
        if (md.isActive(60)){
            md.removeInstrument(60);
        } else {
            md.addInstrument(60);
        }    }//GEN-LAST:event_bellCheckBoxActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed

    }//GEN-LAST:event_generateButtonActionPerformed

    private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeSliderStateChanged
        volumeValue.setText(Integer.toString(volumeSlider.getValue()));
    }//GEN-LAST:event_volumeSliderStateChanged

    private void randomizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeButtonActionPerformed
        this.board = getRandomArray(automatonSize, automatonSize);
        this.generateFrames();
    }//GEN-LAST:event_randomizeButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        md.playFrames(score);
    }//GEN-LAST:event_playButtonActionPerformed
    
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
            returnable[i] = column;
        }
        return returnable;
    }
    
<<<<<<< HEAD
    public static BufferedImage arrayToImage(int[][] array){
        BufferedImage img = new BufferedImage(array.length, array[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int gray = 255-array[i][j];
                Color col = new Color(gray,gray,gray);
                img.setRGB(i, j, col.getRGB());
=======
    public static int[] boxify(int numBoxes, int[] arr){
        int arrayLength = arr.length;
        int[] finalArray = new int[numBoxes];
        int step = arrayLength/numBoxes;
        for (int i = 0; i < numBoxes; i++) {
            for (int j = i*step; j < (i+1)*step; j++) {
                finalArray[i]+=arr[j];
>>>>>>> parent of b13d23d... CellularAutomaton becomes Interface
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
    
    
    public void nextFrame(){
        Graphics g = visualizationPanel.getGraphics();
        BufferedImage img = arrayToImage(score);
        g.drawImage(scale(img,15), 0, 0, rootPane);
//        this.board = GOL.nextFrame(board);
    }
    
    public void generateFrames(){
        GOL gl = new GOL();
        for (int i = 0; i < numFrames; i++) {
            int[] collapsed = collapse(this.board);
            int[] boxed = boxify(8,collapsed);
            score[i] = boxed;
            this.board = gl.nextFrame(this.board);
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
            try{
                sv.nextFrame();
                sleep(60000/sv.tempo);
            } catch (Exception e){
                System.out.println(e.initCause(e));
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bellCheckBox;
    private javax.swing.JButton generateButton;
    private javax.swing.JCheckBox guitarCheckBox;
    private javax.swing.JLabel instrumentLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JCheckBox otherCheckBox;
    private javax.swing.JTextField otherInstrumentTextField;
    private javax.swing.JCheckBox pianoCheckBox;
    private javax.swing.JButton playButton;
    private javax.swing.JButton randomizeButton;
    private javax.swing.JCheckBox snareCheckBox;
    private javax.swing.JLabel tempoLabel;
    private javax.swing.JSlider tempoSlider;
    private javax.swing.JLabel tempoValue;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox visualizationChoice;
    private javax.swing.JLabel visualizationLabel;
    private javax.swing.JPanel visualizationPanel;
    private javax.swing.JLabel volumeLabel;
    private javax.swing.JSlider volumeSlider;
    private javax.swing.JLabel volumeValue;
    // End of variables declaration//GEN-END:variables
}
