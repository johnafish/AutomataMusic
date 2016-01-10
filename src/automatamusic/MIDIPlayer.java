package automatamusic;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.sound.midi.*;

/**
 *
 * @author John Fish <john@johnafish.ca>
 * 
 */
public class MIDIPlayer implements Runnable{
    public int tempo;
    public int[][] slices;
    public List<Integer> activeInstruments;
    private Synthesizer synth;
    private Soundbank sb;
    private Instrument[] possibleInstruments;
    
    public MIDIPlayer(int t, int[][] score){
        this.slices = score;
        this.tempo = t;
        this.activeInstruments = new ArrayList<Integer>();
        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.sb = synth.getDefaultSoundbank();
            this.possibleInstruments = sb.getInstruments();
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public boolean isActive(int id){
        return activeInstruments.contains(id);
    }
    public void addInstrument(int id){
        this.activeInstruments.add(id);
    }
    public void removeInstrument(int id){
        this.activeInstruments.remove(id);
    }

    public void setTempo(int t){
        this.tempo = t;
    }
    public void playFrames(){
        Random rand = new Random();
        MidiChannel[] channels = this.synth.getChannels();
        int[] assignedNotes = new int[slices[0].length];
        int[] assignedInstruments = new int[slices[0].length];
        for (int i = 0; i < assignedNotes.length; i++) {
            assignedNotes[i]=rand.nextInt(35)+48;
            assignedInstruments[i]=rand.nextInt(128);
        }
        try{
        for (int i = 0; i < slices.length; i++) {
            for (int j = 0; j < slices[0].length; j++) {
                channels[j+2].programChange(possibleInstruments[assignedInstruments[j]].getPatch().getProgram());
                channels[j+2].noteOn( assignedNotes[j], slices[i][j]/2 );
            }
            Thread.sleep(60000/this.tempo);
           
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

    @Override
    public void run() {
            this.playFrames();
    }
}
