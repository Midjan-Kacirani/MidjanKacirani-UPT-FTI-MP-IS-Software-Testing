package org.example;

import java.util.Arrays;

public class ArrayExample {
//    Implement the method in the ArrayExample class using the TDD approach:
//    public static String[] removeDuplicates(String[] array)
//    Method should return new array without duplicates.

    //Nqs ekzistojne dy elemente (Strings) te njejta do te mbahet vetem njera dhe tjetra do te hiqet.
    public static String[] removeDuplicates(String[] array){
        int newSize = array.length;
        for (int i = 0; i < newSize; i++) {
            String str = array[i];

            for (int j = i + 1; j < newSize; j++) {
                if (array[j] != null && str.equals(array[j])) {

                    for (int k = j; k < newSize - 1; k++) {
                        array[k] = array[k + 1];
                    }

                    newSize--;

                    j--;
                }
            }
        }
        return Arrays.copyOf(array, newSize);
    }
}
