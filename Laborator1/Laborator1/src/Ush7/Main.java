package Ush7;

public class Main {
    public static void main(String[] args) {
        //Implement the program displaying all the numbers from the range 1 - 100 which are divisible by 5 beginning from 100 (in reverse order).
        for(int i = 100; i >= 1; i--){
            if(i%5 == 0) System.out.println("Numer qe plotepjesohet me 5 eshte dhe " + i);
        }
    }
}
