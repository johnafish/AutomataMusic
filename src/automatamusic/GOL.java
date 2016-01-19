package automatamusic;

import java.util.Random;

/**
 * Conway's Game of Life
 * @author John Fish <john@johnafish.ca>
 */
public class GOL implements CellularAutomaton {
    int[][] previousFrame = new int[width][height];
    
    public static int countNeighbours(int x, int y, int[][] board){
        int neighbours=0;
        //Use a for loop to go through the square around cell (x,y)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                 //(x,y) is not a neighbour of (x,y) so i and j can't both be 0
                if (i!=0||j!=0){
                    int xP = x+i;
                    int yP = y+j;
                    //We have to make sure that we're in the array bounds
                    if (xP>=0 && yP>=0 && xP<width && yP<height){
                        if (board[xP][yP]==255){
                            neighbours++;
                        }
                    }
                }
            }
        }
        return neighbours;
    }
    /**
     * Random static frame.
     * @return int[][] random static of 0, 255.
     */
    public int[][] initializeFrame(){
        Random rand = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                previousFrame[i][j] = rand.nextInt(2)*255;
            }
        }
        return previousFrame;
    }
    /**
     * Apply GOL rules
     * @return int[][] current generation of GOL.
     */
    public int[][] nextFrame(){
        int[][] cellsOnNext = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int neighbours = countNeighbours(i,j, previousFrame);
                //Apply rules if dead
                if (previousFrame[i][j]==0){
                    if(neighbours==3){
                        cellsOnNext[i][j] = 255;
                    }
                    else {
                        cellsOnNext[i][j] = 0;
                    }
                }
                //Apply rules if alive
                else {
                    if (neighbours<2){
                        cellsOnNext[i][j]=0;
                    }
                    else if (neighbours>3){
                        cellsOnNext[i][j] = 0;
                    }
                    else {
                        cellsOnNext[i][j]=255;
                    }
                }
            }
        }
        previousFrame = cellsOnNext;
        return cellsOnNext;
    }
}
