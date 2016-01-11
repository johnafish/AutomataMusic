/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatamusic;

import java.util.Random;

/**
 *
 * @author johnafish
 */
public class ReactionDiffusion implements CellularAutomaton {
    double[][] a = new double[width][height];
    double[][] b = new double[width][height];
    double dA = 1.0;
    double dB = 0.5;
    //Cool (f,k): (.018, .051), 
    double f = .018; 
    double k = .051;
    double delT = 1.0;
    int timeCount = 0;
    int frameSkip = 3;
    
    public double applyLaplacian(int x, int y, int aOrB){ //0==a, 1==b
        //double[][] laplacian = {{0, 0, 0}, {0,1,0}, {0, 0, 0}};
        double[][] laplacian = {{0.05, 0.2, 0.05}, {0.2,-1,0.2}, {0.05, 0.2, 0.05}};
        double sum = 0;
        if(aOrB==0){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int xPos = x+(i-1);
                    int yPos = y+(j-1);
                    if (0<=xPos && xPos<width && 0<=yPos && yPos<height){
                        sum += laplacian[i][j]*a[xPos][yPos];
                    }
                }
            }
        }else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int xPos = x+(i-1);
                    int yPos = y+(j-1);
                    if (0<=xPos && xPos<width && 0<=yPos && yPos<height){
                        sum += laplacian[i][j]*b[xPos][yPos];
                    }
                }
            }
        }
        return sum;
    }
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
                } else {
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
    
    public int[][] nextFrame(){
            double[][] aN = new double[width][height];
            double[][] bN = new double[width][height];
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
