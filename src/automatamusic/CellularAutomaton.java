package automatamusic;

/**
 *
 * @author johnafish
 */
public interface CellularAutomaton {
    int width = AutomataMusic.automatonSize;
    int height = AutomataMusic.automatonSize;
    int[][] nextFrame();
    int[][] initializeFrame();
}
