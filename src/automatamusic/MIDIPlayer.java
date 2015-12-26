package automatamusic;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.sound.midi.*;

/**
 *
 * @author John Fish <john@johnafish.ca>
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
    }
    
    public void initInstruments(){
        Instrument piano = new Instrument("Piano", 0, 2);
        Instrument guitar = new Instrument("Guitar", 27,2);
        Instrument drum = new Instrument("Drum", 37, 9);
        Instrument bell = new Instrument("Bell", 112, 2);
        Instrument[] initial = {piano, guitar, drum, bell};
        
        for (Instrument ins : initial) {
            createInstrument(ins);
        }
    }
    public void addInstrument(String ins){
        this.activeInstruments.add(this.possibleInstruments.get(ins));
    }
    public void createInstrument(Instrument ins){
        this.possibleInstruments.put(ins.name, ins);
    }
    public void setTempo(int t){
        this.tempo = t;
        seq.setTempoInBPM(t);
    }
    
    public void playFrame(int[] boxes){
        try {
                seq.close();
                this.s = new Sequence(javax.sound.midi.Sequence.PPQ,24);
                this.t = s.createTrack();

                mm = new ShortMessage();
                mm.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 0, 0);
                t.add(new MidiEvent(mm,(long)0));
                
            for(Instrument ins : this.activeInstruments){
                
                mm = new ShortMessage();
                mm.setMessage(ShortMessage.PROGRAM_CHANGE, ins.channel, ins.ID, 93);
                t.add(new MidiEvent(mm,(long)seq.getTickPosition()));
                
                mm = new ShortMessage();
                mm.setMessage(144, ins.ID, 32);
                t.add(new MidiEvent(mm,(long)seq.getTickPosition()));

                mm = new ShortMessage();
                mm.setMessage(128,ins.ID,32);
                t.add(new MidiEvent(mm,(long)seq.getTickPosition()+1));
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
