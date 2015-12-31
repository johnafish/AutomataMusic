package automatamusic;

/**
 *
 * @author John Fish <john@johnafish.ca>
 */
public class GOL {
    public static int width=AutomataMusic.GOLSize;
    public static int height= AutomataMusic.GOLSize;
    
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
    
    public static int[][] nextFrame(int[][] previousFrame){
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
        return cellsOnNext;
    }
}
