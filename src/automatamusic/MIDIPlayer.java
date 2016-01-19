package automatamusic;

import java.util.List;
import java.util.Random;
import javax.sound.midi.*;

/**
 * MIDI Player Thread
 * @author John Fish <john@johnafish.ca>
 */
public class MIDIPlayer implements Runnable{
    /**
     * Variable Initialization
     */
    public int tempo;
    public int[][] slices;
    public List<Integer> activeInstruments;
    private Synthesizer synth;
    private Soundbank sb;
    private Instrument[] possibleInstruments;
    
    /**
     * MIDIPlayer
     * Synthesizes a MIDI sequence from a score of integers.
     * 
     * @param t tempo of the piece to be played.
     * @param score score of the piece to be played.
     * @param instruments potential instruments to be used.
     */
    public MIDIPlayer(int t, int[][] score, List<Integer> instruments){
        this.slices = score;
        this.tempo = t;
        this.activeInstruments = instruments;
        //Open synthesizer and retrieve instruments
        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.sb = synth.getDefaultSoundbank();
            this.possibleInstruments = sb.getInstruments();
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    /**
     * playFrames
     * 
     * Assigns arbitrary notes and instruments to each "row" and plays the score
     * at the appropriate tempo.
     */
    public void playFrames(){
        Random rand = new Random();
        MidiChannel[] channels = this.synth.getChannels();
        int[] assignedNotes = new int[slices[0].length];
        int[] assignedInstruments = new int[slices[0].length];
        //Assign notes and instruments
        for (int i = 0; i < assignedNotes.length; i++) {
            assignedNotes[i]=rand.nextInt(8)+60; //Middle octave
            assignedInstruments[i]=activeInstruments.get(rand.nextInt(activeInstruments.size())); //Random selection from activeInstruments
        }
        try{
            for (int i = 0; i < slices.length; i++) {
                //Play each note
                for (int j = 0; j < slices[0].length; j++) {
                    channels[j].programChange(possibleInstruments[assignedInstruments[j]].getPatch().getProgram());
                    channels[j].noteOn( assignedNotes[j], slices[i][j]/2 );
                }
                //Delay appropriate amount for tempo
                Thread.sleep(60000/this.tempo);
                //Turn all notes off
                for (int j = 0; j < channels.length; j++) {
                    MidiChannel channel = channels[j];
                    channel.allNotesOff();
                }
            }
            
        } catch (Exception e){
            for (int j = 0; j < channels.length; j++) {
                MidiChannel channel = channels[j];
                channel.allNotesOff();
            }
        }
    }
    /**
     * run()
     * 
     * Called when thread.start() is called.
     */
    @Override
    public void run() {
            this.playFrames();
    }
}
