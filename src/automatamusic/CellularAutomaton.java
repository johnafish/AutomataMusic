package automatamusic;

/**
 * CellularAutomaton Interface
 * @author johnafish
 */
public interface CellularAutomaton {
    //Field initialization
    int width = AutomataMusic.automatonSize;
    int height = AutomataMusic.automatonSize;
    /**
     * Get the next frame of a cellular automaton.
     * @return int[][] the next frame
     */
    int[][] nextFrame();
    /**
     * Generate the first frame of a cellular automaton.
     * @return int[][] the first frame.
     */
    int[][] initializeFrame();
}
