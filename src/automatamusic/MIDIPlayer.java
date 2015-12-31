package automatamusic;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.sound.midi.*;

/**
 *
 * @author John Fish <john@johnafish.ca>
 * 
 * TODO: Turn into Synthesizer instead of Sequencer
 */
public class MIDIPlayer {
    public int tempo;
    public List<Instrument> activeInstruments;
    public Map<String, Instrument> possibleInstruments;
    public Sequence s;
    public Sequencer seq;
    public Track t;
    public ShortMessage mm;
    
    public MIDIPlayer(){
        
        this.activeInstruments = new ArrayList<Instrument>();
        this.possibleInstruments = new HashMap<String,Instrument>();
        try{
            this.s = new Sequence(javax.sound.midi.Sequence.PPQ,24);
            this.t = s.createTrack();
            
            mm = new ShortMessage();
            mm.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 0, 0);
            t.add(new MidiEvent(mm,(long)0));

            seq = MidiSystem.getSequencer();
            seq.open();
            seq.setSequence(s);
            seq.start();
        } catch (Exception e){
            System.out.println(e+" in initializing.");
        }
        this.initInstruments();
        this.setTempo(120);
        this.addInstrument("Piano");
    }
    
    public void initInstruments(){
        Instrument piano = new Instrument("Piano", 0, 0);
        Instrument guitar = new Instrument("Guitar", 28,1);
        Instrument drum = new Instrument("Drum", 34, 9);
        Instrument bell = new Instrument("Bell", 112, 2);
        Instrument[] initial = {piano, guitar, drum, bell};
        
        for (Instrument ins : initial) {
            createInstrument(ins);
        }
    }
    public void addInstrument(String ins){
        this.activeInstruments.add(this.possibleInstruments.get(ins));
    }
    public void removeInstrument(String ins){
        this.activeInstruments.remove(this.possibleInstruments.get(ins));
    }
    public boolean isActive(String ins){
        return this.activeInstruments.contains(this.possibleInstruments.get(ins));
    }
    public void createInstrument(Instrument ins){
        this.possibleInstruments.put(ins.name, ins);
    }
    public void setTempo(int t){
        this.tempo = t;
        seq.setTempoInBPM(t);
    }
    public int scale (int val){
        double max = (double)(400/this.activeInstruments.size())*400*255;
        double ratio = (double) val/max;
        double value = 50+(128-50)*ratio;
        return (int) Math.round(value);
    }
    public void playFrame(int[] boxes){
        try {
                seq.close();
                this.s = new Sequence(javax.sound.midi.Sequence.PPQ,24);
                this.t = s.createTrack();

                mm = new ShortMessage();
                mm.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 0, 0);
                t.add(new MidiEvent(mm,(long)0));
                
            int counter = 0;
            for(Instrument ins : this.activeInstruments){
                
                //Changes the instrument??
                mm = new ShortMessage();
                mm.setMessage(ShortMessage.PROGRAM_CHANGE, ins.channel, ins.ID, 0);
                t.add(new MidiEvent(mm,(long)seq.getTickPosition()));
                
                //Sets the note on
                mm = new ShortMessage();
                mm.setMessage(ShortMessage.NOTE_ON, ins.channel, scale(boxes[counter]), 50);
                t.add(new MidiEvent(mm,(long)seq.getTickPosition()));
                
                //Sets the note off
                mm = new ShortMessage();
                mm.setMessage(ShortMessage.NOTE_OFF, ins.channel, scale(boxes[counter]), 50);
                t.add(new MidiEvent(mm,(long)seq.getTickPosition()+1));
                
                counter++;
            }
            seq = MidiSystem.getSequencer();
            seq.open();
            seq.setSequence(s);
            seq.start();
	}
        catch(Exception e) {
            System.out.println("Exception caught " + e.toString());
	}
    }
}
