package Ush4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Declare an integer variable and assign any value to this variable.
        System.out.println("Jepni nje numer: ");
        int vlere = scanner.nextInt();

        //Then using a conditional statement check if it is an even number.
        //If yes, please display proper information on the screen.
        if(vlere % 2 == 0) System.out.println("Numri eshte numer cift");
        else System.out.println("Numri eshte numer tek");

    }
}
