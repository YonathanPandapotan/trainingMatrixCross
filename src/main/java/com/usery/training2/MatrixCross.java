package com.usery.training2;

import java.util.ArrayList;
import java.util.Random;

public class MatrixCross {
    private int xLength;
    private int yLength;
    private int countOne;
    private int countZero;
    private String arr[][];
    private ArrayList<String> answers;

    MatrixCross(int xLength, int yLength){
        this.xLength =xLength;
        this.yLength = yLength;
        this.answers = new ArrayList<String>();
        seedArray();
    }

    public void seedArray(){
        int temp;
        Random randomGenerator = new Random();
        this.arr = new String[this.yLength][this.xLength];

        for (int i=0;i<this.yLength;i++){
            for (int j=0;j<this.xLength;j++){
                temp = randomGenerator.nextInt(2);
                if(temp == 1)
                    countOne++;
                else
                    countZero++;
                this.arr[i][j] = String.valueOf(temp);
            }

        }
    }

    public void markCross(){
        for (int i=0;i<yLength-2;i++){
            for (int j=1;j<xLength-1;j++){
                if(arr[i][j].equals("1") && arr[i+1][j-1].equals("1") && arr[i+1][j].equals("1") && arr[i+1][j+1].equals("1") && arr[i+2][j].equals("1")){
                    arr[i][j]="*";
                    arr[i+1][j-1]="*";
                    arr[i+1][j]="*";
                    arr[i+1][j+1]="*";
                    arr[i+2][j]="*";
                    answers.add("(" + (j+1) + ", " + (i+1) + ")");
                }
            }
        }
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String[][] getArr() {
        return arr;
    }

    public int getCountOne() {
        return countOne;
    }

    public int getCountZero() {
        return countZero;
    }
}
