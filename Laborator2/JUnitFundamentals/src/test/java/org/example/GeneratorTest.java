package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

    @Test
    public void testRandomNumberGeneratorInRange(){
        int randomNumber = Generator.randomNumberGeneratorInRange();
        System.out.println(randomNumber);

        Assertions.assertTrue(randomNumber<=10 && randomNumber>=-10, "Sakte!");
    }
}
