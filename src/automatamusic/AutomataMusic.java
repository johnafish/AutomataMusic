package automatamusic;

/**
 * Imports
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

/**
 * @author John Fish <john@johnafish.ca>
 * @version 1.0
 * @since January 18, 2016
 * 
 * Plays "music" from cellular automata, there are four potential automata:
 * -GOL
 * -Reaction Diffusion
 * -Static (Not technically automata)
 * -Wolfram's Rule 30
 */

public class AutomataMusic extends javax.swing.JFrame {
    //Static fields
    public static int automatonSize = 18;
    
    //Initial form values
    public int tempo = 80;
    public int numFrames = 45;
    public String chosenSim = "Game of Life";
    
    //Generated board fields
    public int[][] board;
    public int[][][] boards = new int[numFrames][automatonSize][automatonSize];
    public int[][] score = new int[numFrames][8];
    
    //Musical fields
    public List<Integer> instruments = new ArrayList();
    public Thread playThread;
    
    //Animation fields
    public boolean animating = false;
    public int frameNo = 0;
    
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
        percussionCheckBox = new javax.swing.JCheckBox();
        guitarCheckBox = new javax.swing.JCheckBox();
        brassCheckBox = new javax.swing.JCheckBox();
        visualizationLabel = new javax.swing.JLabel();
        visualizationChoice = new javax.swing.JComboBox();
        stopButton = new javax.swing.JButton();
        volumeValue = new javax.swing.JLabel();
        frameSlider = new javax.swing.JSlider();
        volumeLabel = new javax.swing.JLabel();
        randomizeButton = new javax.swing.JButton();
        visualizationPanel = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        automataPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        stringsCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setName("MainScreen"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(640, 360));

        title.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        title.setText("Automusic");

        tempoSlider.setMaximum(240);
        tempoSlider.setMinimum(40);
        tempoSlider.setMinorTickSpacing(20);
        tempoSlider.setPaintLabels(true);
        tempoSlider.setPaintTicks(true);
        tempoSlider.setValue(80);
        tempoSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tempoSliderStateChanged(evt);
            }
        });

        tempoLabel.setText("Tempo");

        tempoValue.setText("80");

        instrumentLabel.setText("Instruments");

        pianoCheckBox.setLabel("Piano");
        pianoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pianoCheckBoxActionPerformed(evt);
            }
        });

        percussionCheckBox.setText("Percussion");
        percussionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percussionCheckBoxActionPerformed(evt);
            }
        });

        guitarCheckBox.setText("Guitar");
        guitarCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guitarCheckBoxActionPerformed(evt);
            }
        });

        brassCheckBox.setText("Brass");
        brassCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brassCheckBoxActionPerformed(evt);
            }
        });

        visualizationLabel.setText("Simulation");

        visualizationChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Game of Life", "Reaction Diffusion", "Static", "Wolfram Rule 30" }));
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

        volumeLabel.setText("Frames");

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

        automataPanel.setPreferredSize(new java.awt.Dimension(180, 180));

        javax.swing.GroupLayout automataPanelLayout = new javax.swing.GroupLayout(automataPanel);
        automataPanel.setLayout(automataPanelLayout);
        automataPanelLayout.setHorizontalGroup(
            automataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        automataPanelLayout.setVerticalGroup(
            automataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setText("Frame 1");

        stringsCheckBox.setText("Strings");
        stringsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stringsCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(visualizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(instrumentLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pianoCheckBox)
                                        .addGap(52, 52, 52))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(percussionCheckBox)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guitarCheckBox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(brassCheckBox)
                                        .addGap(217, 217, 217)
                                        .addComponent(jLabel1))))
                            .addComponent(title))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(visualizationLabel)
                            .addComponent(visualizationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(randomizeButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stopButton))
                            .addComponent(volumeLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tempoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tempoValue))
                                .addComponent(tempoLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(frameSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(volumeValue)))
                            .addComponent(stringsCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(automataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instrumentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pianoCheckBox)
                    .addComponent(guitarCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brassCheckBox)
                    .addComponent(percussionCheckBox)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stringsCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(volumeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frameSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volumeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tempoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visualizationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visualizationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(randomizeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playButton)
                            .addComponent(stopButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(automataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(visualizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Adds/Removes piano instruments from instrument pool on check/uncheck.
     * @param evt the click event.
     */
    private void pianoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pianoCheckBoxActionPerformed
        if(instruments.contains(0)){ //0,1,2 are General MIDI piano values.
            for (int i = 0; i < 2; i++) { 
                instruments.remove(instruments.indexOf(i));
            }
        } else {
            for (int i = 0; i < 2; i++) {
                instruments.add(i);
            }
        }
    }//GEN-LAST:event_pianoCheckBoxActionPerformed
    /**
     * Adds/Removes guitar instruments from instrument pool on check/uncheck.
     * @param evt the click event.
     */
    private void guitarCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guitarCheckBoxActionPerformed
        if(instruments.contains(25)){ //25,27,31 are General MIDI guitar values.
            instruments.remove(instruments.indexOf(25));
            instruments.remove(instruments.indexOf(27));
            instruments.remove(instruments.indexOf(31));
        } else {
            instruments.add(25);
            instruments.add(27);
            instruments.add(31);
        }
        
    }//GEN-LAST:event_guitarCheckBoxActionPerformed
    /**
     * Adds/Removes percussion instruments from instrument pool on check/uncheck.
     * @param evt the click event.
     */
    private void percussionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percussionCheckBoxActionPerformed
        if(instruments.contains(112)){ //112 to 119 are General MIDI percussion values.
            for (int i = 112; i < 119; i++) {
                instruments.remove(instruments.indexOf(i));
            }
        } else {
            for (int i = 112; i < 119; i++) {
                instruments.add(i);
            }
        }
    }//GEN-LAST:event_percussionCheckBoxActionPerformed
    /**
     * Sets tempo based on slider value.
     * @param evt the StateChanged event.
     */
    private void tempoSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tempoSliderStateChanged
        this.tempo = tempoSlider.getValue();
        tempoValue.setText(Integer.toString(this.tempo));
    }//GEN-LAST:event_tempoSliderStateChanged
    /**
     * Adds/Removes brass instruments from instrument pool on check/uncheck.
     * @param evt the click event.
     */
    private void brassCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brassCheckBoxActionPerformed
        if(instruments.contains(56)){ //56-62 are General MIDI brass values.
            for (int i = 56; i < 62; i++) {
                instruments.remove(instruments.indexOf(i));
            }
        } else {
            for (int i = 56; i < 62; i++) {
                instruments.add(i);
            }
        }
        }//GEN-LAST:event_brassCheckBoxActionPerformed
    /**
     * Stops the animation and playing of the "music".
     * @param evt the click event.
     */
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        playThread.interrupt(); //Interrupt the playing thread
        this.animating=false;
    }//GEN-LAST:event_stopButtonActionPerformed
    /**
     * Sets the number of frames in the piece.
     * @param evt the StateChanged event.
     */
    private void frameSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frameSliderStateChanged
        volumeValue.setText(Integer.toString(frameSlider.getValue()));
        this.numFrames = frameSlider.getValue();
        this.score = new int[this.numFrames][8];
        this.boards = new int[this.numFrames][automatonSize][automatonSize];
        this.generateFrames();
    }//GEN-LAST:event_frameSliderStateChanged
   /**
    * Randomizes the board and score.
    * @param evt the click event.
    */
    private void randomizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeButtonActionPerformed
        if(!animating){
            this.generateFrames();
        }
    }//GEN-LAST:event_randomizeButtonActionPerformed
    /**
     * Starts the animation and plays the "music".
     * @param evt the click event.
     */
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        playThread = new Thread(new MIDIPlayer(tempo,score,instruments));
        playThread.start();
        this.animating = true;
    }//GEN-LAST:event_playButtonActionPerformed
    /**
     * Changes the type of simulation.
     * @param evt the ActionPerformed event.
     */
    private void visualizationChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizationChoiceActionPerformed
        this.chosenSim = visualizationChoice.getSelectedItem().toString();
        this.generateFrames();
    }//GEN-LAST:event_visualizationChoiceActionPerformed

    /**
     * Adds/Removes strings instruments from instrument pool on check/uncheck.
     * @param evt the click event.
     */
    private void stringsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stringsCheckBoxActionPerformed
        if(instruments.contains(40)){ //40-48 are General MIDI strings values.
            for (int i = 40; i < 48; i++) {
                instruments.remove(instruments.indexOf(i));
            }
        } else {
            for (int i = 40; i < 48; i++) {
                instruments.add(i);
            }
        }
        
    }//GEN-LAST:event_stringsCheckBoxActionPerformed
    
    /**
     * Sleeps the thread.
     * @param millis milliseconds thread to be slept for.
     * @throws InterruptedException 
     */
    public static void sleep(int millis) throws InterruptedException{
        Thread.sleep(millis);
    }
    
    
    /**
     * Collapse 2D array into 1D array.
     * Averages values of column.
     * @param arr array to be collapsed.
     * @return int[] collapsed array.
     */
    public static int[] collapse(int[][] arr){
        int[] returnable = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int column = 0; //Column sum
            for (int j = 0; j < arr[0].length; j++) {
                column+=arr[i][j];
            }
            returnable[i] = column/arr[0].length;
        }
        return returnable;
    }
    /**
     * Compresses 1D array into boxes.
     * @param numBoxes number of boxes array to be compressed to.
     * @param arr array to compress.
     * @return int[numBoxes] boxified array.
     */
    public static int[] boxify(int numBoxes, int[] arr){
        int arrayLength = arr.length;
        int[] finalArray = new int[numBoxes];
        int step = arrayLength/numBoxes; //We want integer division here

        for (int i = 0; i < numBoxes; i++) {
            int steps = 0; //Number of elements compressed.
            for (int j = i*step; j < (i+1)*step; j++) {
                finalArray[i]+=arr[j];
                steps++;
            }
            finalArray[i]/=steps;
        }
        return finalArray;
    }
    
    /**
     * Converts integer array to grayscale image.
     * @param array integer array to be converted.
     * @return BufferedImage of grayscale representation of image.
     */
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
    
    /**
     * Scales BufferedImage
     * @param image BufferedImage to be scaled
     * @param scalingFactor integral scaling factor
     * @return BufferedImage scaled by a factor of scalingFactor
     */
    public static BufferedImage scale(BufferedImage image, int scalingFactor){
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scalingFactor, scalingFactor);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return bilinearScaleOp.filter(
            image,
            new BufferedImage(image.getWidth()*scalingFactor, image.getHeight()*scalingFactor, image.getType()));
    }
    
    /**
     * Next animation frame
     * @param i how far along in the animation.
     */
    public void nextFrame(int i){
        //Draw lower visualization
        Graphics g = visualizationPanel.getGraphics();
        BufferedImage img = arrayToImage(score);
        Color gray = new Color(238,238,238);
        g.setColor(gray);
        g.fillRect(0, 0, 675, 120);
        g.drawImage(scale(img,15), -15*i, 0, rootPane);
        
        //Draw upper visualization of board
        if (i<numFrames){
            Graphics h = this.automataPanel.getGraphics();
            BufferedImage b = arrayToImage(boards[i]);
            h.setColor(gray);
            h.fillRect(0, 0, 300, 300);
            h.drawImage(scale(b,(300/automatonSize)), 0, 0, rootPane);
        }
    }
    
    /**
     * Generate the frames from the appropriate automata.
     */
    public void generateFrames(){
        this.frameNo = 0;
        CellularAutomaton gl;
        if (chosenSim.equalsIgnoreCase("Game of Life")){
            gl = new GOL();
        } else if (chosenSim.equalsIgnoreCase("Reaction Diffusion")){
            gl = new ReactionDiffusion();
        } else if (chosenSim.equalsIgnoreCase("Static")){
            gl = new Static();
        } else{
            gl = new Elementary();
        }
        //Generate->Collapse->Boxify
        this.board = gl.initializeFrame();//Frame 1
        for (int i = 0; i < numFrames; i++) {
            boards[i]=this.board;
            int[] collapsed = collapse(this.board);
            int[] boxed = boxify(8,collapsed);
            score[i] = boxed;
            this.board = gl.nextFrame();
        }
    }
    
    public static void main(String args[]) {
        //System look and feel
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            System.out.println(e);
        }
        //Create main object
        AutomataMusic sv = new AutomataMusic();
        sv.generateFrames();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sv.setVisible(true);
            }
        });
        //Animation loop
        while(true){
            sv.nextFrame(sv.frameNo);
            //Disable boxes when animating
            if(sv.animating){
                sv.guitarCheckBox.setEnabled(false);
                sv.pianoCheckBox.setEnabled(false);
                sv.stringsCheckBox.setEnabled(false);
                sv.percussionCheckBox.setEnabled(false);
                sv.brassCheckBox.setEnabled(false);
                sv.tempoSlider.setEnabled(false);
                sv.frameSlider.setEnabled(false);
                sv.visualizationChoice.setEnabled(false);
                sv.randomizeButton.setEnabled(false);
                sv.playButton.setEnabled(false);
                sv.stopButton.setEnabled(true);
                sv.frameNo++;
            } else { //Enable boxes if not animating
                sv.guitarCheckBox.setEnabled(true);
                sv.pianoCheckBox.setEnabled(true);
                sv.stringsCheckBox.setEnabled(true);
                sv.percussionCheckBox.setEnabled(true);
                sv.brassCheckBox.setEnabled(true);
                sv.tempoSlider.setEnabled(true);
                sv.frameSlider.setEnabled(true);
                sv.visualizationChoice.setEnabled(true);
                sv.randomizeButton.setEnabled(true);
                sv.playButton.setEnabled(true);
                sv.stopButton.setEnabled(false);
                sv.frameNo = 0;
            } 
            if(sv.frameNo==sv.numFrames){ //Stop animation at end of animation
                sv.animating = false;
            }
            if(sv.instruments.isEmpty()){ //Can't play with no instruments
                sv.playButton.setEnabled(false);
            }
            try{
                Thread.sleep(60000/sv.tempo);
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel automataPanel;
    private javax.swing.JCheckBox brassCheckBox;
    private javax.swing.JSlider frameSlider;
    private javax.swing.JCheckBox guitarCheckBox;
    private javax.swing.JLabel instrumentLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox percussionCheckBox;
    private javax.swing.JCheckBox pianoCheckBox;
    private javax.swing.JButton playButton;
    private javax.swing.JButton randomizeButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JCheckBox stringsCheckBox;
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
