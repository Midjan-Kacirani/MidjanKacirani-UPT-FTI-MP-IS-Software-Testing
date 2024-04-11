package Ush5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Declare an integer variable and assign any value to it.
        System.out.println("Jepni nje numer: ");
        int number = scanner.nextInt();

        //Next check, if the value of this variable is greater, or less, or equal to zero.
        if(number > 0 ) System.out.println("Numri eshte me i madh se 0");
        else if (number == 0) System.out.println("Numri eshte 0");
        else System.out.println("Numri eshte me i vogel se 0");
    }
}
