package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ArrayExampleTest {

    String[] testcase, expected;

    @Test
    public void removeDuplicate_usecase1() {
        expected = testcase = new String[]{"tekst1", "tekst2", "tekst3", "tekst4"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

    @Test
    public void removeDuplicate_usecase2() {
        testcase = new String[]{"tekst1", "tekst1", "tekst2", "tekst3"};
        expected = new String[]{"tekst1", "tekst2", "tekst3"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

    @Test
    public void removeDuplicate_usecase3() {
        testcase = new String[]{"tekst1", "tekst2", "tekst2", "tekst3"};
        expected = new String[]{"tekst1", "tekst2", "tekst3"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

    @Test
    public void removeDuplicate_usecase4() {
        testcase = new String[]{"tekst1", "tekst2", "tekst3", "tekst3"};
        expected = new String[]{"tekst1", "tekst2", "tekst3"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

    @Test
    public void removeDuplicate_usecase5() {
        testcase = new String[]{"tekst1", "tekst1", "tekst1", "tekst1"};
        expected = new String[]{"tekst1"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

    @Test
    public void removeDuplicate_usecase6() {
        testcase = new String[]{"tekst1", "tekst2", "tekst3", "tekst1"};
        expected = new String[]{"tekst1", "tekst2", "tekst3"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

    @Test
    public void removeDuplicate_usecase7() {
        testcase = new String[]{"tekst1", "tekst2", "tekst3", "tekst1", "tekst4"};
        expected = new String[]{"tekst1", "tekst2", "tekst3", "tekst4"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

    @Test
    public void removeDuplicate_usecase8() {
        testcase = new String[]{"tekst1", "tekst2", "tekst1", "tekst3", "tekst1", "tekst4", "tekst1"};
        expected = new String[]{"tekst1", "tekst2", "tekst3", "tekst4"};
        Assertions.assertArrayEquals(expected, ArrayExample.removeDuplicates(testcase));
    }

}
