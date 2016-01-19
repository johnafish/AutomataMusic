package automatamusic;

import java.util.Random;

/**
 * Wolfram Elementary Automaton Rule 30
 * Is chaotic in nature, best at high BPM with percussion+piano/brass/strings.
 * Runs on a 2D array because it implements CellularAutomaton which has abstract
 * classes requiring 2D arrays to be returned. Could just be 1D.
 * 
 * @author johnafish
 */
public class Elementary implements CellularAutomaton {
    Random rand = new Random();
    int[][] previousBoard = new int[width][1];
    
    /**
     * Applies Wolfram's Rule 30
     * @return int[][] next generation of automaton.
     */
    @Override
    public int[][] nextFrame() {
        int[][] board = new int[width][1];
        for (int i = 0; i < width; i++) {
            //Counting neighbours
            int neighbours = 0;
            if(i==0){
                if(previousBoard[i][0]!=0){
                    neighbours++;
                }
            } else if (i==width-1){
                if(previousBoard[i][0]!=0){
                    neighbours++;
                }
            } else {
                if(previousBoard[i-1][0]!=0){
                    neighbours++;
                }
                if(previousBoard[i+1][0]!=0){
                    neighbours++;
                }
            }
            
            //Applies Rule 30: http://mathworld.wolfram.com/Rule30.html
            if(neighbours==0){
                board[i][0]=previousBoard[i][0];
            } else if (neighbours == 1){
                board[i][0]=255-previousBoard[i][0];
            } else if (neighbours==2){
                board[i][0]=0;
            }
        }
        previousBoard = board;
        return board;
    }
    
    /**
     * initializeFrame
     * A random 2D array(with height 1, so effectively 1D).
     * @return int[][] a random 2D array of height 1, full of 0, 255.
     */
    @Override
    public int[][] initializeFrame() { //Random array (effectively 1D)
        for (int i = 0; i < width; i++) {
            previousBoard[i][0]=rand.nextInt(2)*255;
        }
        return previousBoard;
    }
        
}
