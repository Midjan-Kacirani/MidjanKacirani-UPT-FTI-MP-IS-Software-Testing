package Ush6;

public class Main {
    public static void main(String[] args) {
        //Implement the program displaying all the numbers from the range 5 – 100 (use ‘for’ loop).
        for(int i = 5 ; i <= 100; i++){
            System.out.println("Numri i rradhes eshte " + i);
        }
        System.out.println("==========");
        //Implement the same program, but using a ‘while’ loop.
        int iterator = 5;
        while(iterator <= 100){
            System.out.println("Numri i rradhes eshte " + iterator);
            iterator++;
        }

    }
}
