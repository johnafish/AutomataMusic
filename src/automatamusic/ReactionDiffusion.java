package automatamusic;

import java.util.Random;

/**
 * Reaction Diffusion
 * @author johnafish
 */
public class ReactionDiffusion implements CellularAutomaton {
    //A and B concentration matrices
    double[][] a = new double[width][height];
    double[][] b = new double[width][height];
    
    //Constants for reaction diffusion
    double dA = 1.0;
    double dB = 0.5;
    double f = .018; 
    double k = .051;
    double delT = 1.0;
    
    /**
     * Applies discrete laplacian.
     * @param x x-coordinate of index to apply laplacian to.
     * @param y y-coordinate of index to apply laplacian to.
     * @param aOrB which concentration matrix to apply laplacian to.
     * @return value of the laplacian at (x,y).
     */
    public double applyLaplacian(int x, int y, int aOrB){ //0==a, 1==b
        double[][] laplacian = {{0.05, 0.2, 0.05}, {0.2,-1,0.2}, {0.05, 0.2, 0.05}};
        double sum = 0;
 
        if(aOrB==0){//For a
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int xPos = x+(i-1);
                    int yPos = y+(j-1);
                    //If in boundaries, apply sum like a kernel.
                    if (0<=xPos && xPos<width && 0<=yPos && yPos<height){
                        sum += laplacian[i][j]*a[xPos][yPos];
                    }
                }
            }
        } else {//For b
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int xPos = x+(i-1);
                    int yPos = y+(j-1);
                    //If in boundaries, apply sum like a kernel.
                    if (0<=xPos && xPos<width && 0<=yPos && yPos<height){
                        sum += laplacian[i][j]*b[xPos][yPos];
                    }
                }
            }
        }
        return sum;
    }
    
    /**
     * initializeFrame()
     * In this case, our initial frame is a circle with random radius in the
     * center of our board.
     * 
     * @return int[][] the initial board
     */
    public int[][] initializeFrame(){
        Random rand = new Random();
        f = rand.nextDouble();
        k = rand.nextDouble();
        int radius = rand.nextInt(AutomataMusic.automatonSize/4);
        int midX = width/2;
        int midY = height/2;
        boolean circle = true;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int delX = i-midX;
                int delY = j-midY;
                
                if(circle){
                    double distance = Math.sqrt(delX*delX+delY*delY);
                    if (distance<radius){
                        a[i][j] = 0;
                        b[i][j] = 1;
                    } else {
                        a[i][j] = 1;
                        b[i][j] = 0;
                    }
                } else { //Can also draw a square
                    if (delX>-radius && delX<radius && delY>-radius &&delY<radius){
                        a[i][j] = 1;
                        b[i][j] = 1;
                    }else {
                        a[i][j] = 1;
                        b[i][j] = 0;
                    }
                }
            }
        }
        //Weights appropriate a,b to grayscale.
        int[][] finalArray = new int[width][height];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int value = (int) Math.round(128+127*a[i][j] - 127*b[i][j]);
                if (value<0){
                    value = 0;
                } else if (value>255){
                    value = 255;
                }
                finalArray[i][j]=value;
            }
        }
        return finalArray;
    }
    /**
     * Applies reaction diffusion equation.
     * @return int[][] next frame of the simulation.
     */
    public int[][] nextFrame(){
        //New concentration matrices.
        double[][] aN = new double[width][height];
        double[][] bN = new double[width][height];
        //Apply reaction diffusion equation to each pixel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double aP = a[i][j];
                double bP = b[i][j];
                double reaction = aP*bP*bP;
                aN[i][j] = aP+delT*(dA*applyLaplacian(i,j,0)-reaction+f*(1-aP));
                bN[i][j] = bP+delT*(dB*applyLaplacian(i,j,1)+reaction-bP*(k+f));
            }
        }
        a = aN;
        b = bN;
        //Convert from concentration matrices to grayscale
        int[][] finalArray = new int[width][height];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int value = (int) Math.round(128+127*a[i][j] - 127*b[i][j]);
                if (value<0){
                    value = 0;
                } else if (value>255){
                    value = 255;
                }
                finalArray[i][j]=255-value;
            }
        }
        return finalArray;
    }
}
