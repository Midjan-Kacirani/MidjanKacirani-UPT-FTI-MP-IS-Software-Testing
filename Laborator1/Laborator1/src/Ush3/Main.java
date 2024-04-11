package Ush3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declare two variables of String type
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jepni string e pare: ");
        String input1 = scanner.next();
        System.out.println("Jepni string e dyte: ");
        String input2 = scanner.next();

        //declare the boolean variable, which will store the result of checking if two previously declared String values are equal
        boolean janeTeNjejta = input1.equals(input2);

        //Display boolean value on the standard output (screen)
        System.out.println("A jane te njejta strings te vendosur? Pergjigje: " + janeTeNjejta);
    }
}
