package automatamusic;

/**
 *
 * @author John Fish <john@johnafish.ca>
 */
public class Instrument {
    public String name;
    public int ID, channel;
    
    public Instrument(String n, int i, int c){
        this.name = n;
        this.ID = i;
        this.channel = c;
    }
}
