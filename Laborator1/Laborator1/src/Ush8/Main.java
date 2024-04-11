package Ush8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Implement the program, where you have to read 6 integers (using Scanner class) and save them in the previously declared 6-element table.
        int[] sixElementTable = new int[6];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Me poshte do te vendosni 6 numra!");

        for (int i = 1; i <=6; i++){
            System.out.println("Jepni numri e " + i);
            sixElementTable[i-1] = scanner.nextInt();
        }

        //Then compute an arithmetic average for all table values
        int shuma = 0;
        for(int numer : sixElementTable){
            shuma += numer;
        }

        //display the result on the standard output.
        System.out.println("Mesatarja e numrave te vendosur eshte: "  + (((double)shuma) / 6));


    }
}
