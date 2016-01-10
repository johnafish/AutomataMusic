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
public class Static implements CellularAutomaton{
    Random rand = new Random();
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

    @Override
    public int[][] initializeFrame() {
        return this.nextFrame();
    }
    
}
