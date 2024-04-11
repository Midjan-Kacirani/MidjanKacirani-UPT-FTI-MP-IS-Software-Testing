package org.example;

import java.util.Random;

public class Generator {
    public static int randomNumberGeneratorInRange() {
        Random rand = new Random();
        return rand.nextInt(21) - 10; // generates a random number between -10 and 10
    }

}
