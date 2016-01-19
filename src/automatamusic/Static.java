package automatamusic;

import java.util.Random;

/**
 * Static
 * @author johnafish
 */
public class Static implements CellularAutomaton{
    Random rand = new Random();
    
    /**
     * Random static
     * @return int[][] random static of 0, 255.
     */
    @Override
    public int[][] nextFrame() {
        int[][] board = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = rand.nextInt(2)*255;
            }
        }
        return board;
    }

    /**
     * Random static
     * @return int[][] random static of 0, 255.
     */
    @Override
    public int[][] initializeFrame() {
        return this.nextFrame();
    }
    
}
