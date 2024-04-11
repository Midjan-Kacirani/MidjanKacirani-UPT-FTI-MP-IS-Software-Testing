package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void Email_testcase1() {
        String email = "user@example.com";
        Assertions.assertTrue(Email.validate(email));
    }

    @Test
    public void Email_testcase2() {
        String email = "user.name+tag@example.co.uk";
        Assertions.assertTrue(Email.validate(email));
    }

    @Test
    public void Email_testcase3() {
        String email = "userexample.com";
        Assertions.assertFalse(Email.validate(email));
    }

    @Test
    public void Email_testcase4() {
        String email = "user@@example.com";
        Assertions.assertFalse(Email.validate(email));
    }

    @Test
    public void Email_testcase5() {
        String email = "user@.com";
        Assertions.assertFalse(Email.validate(email));
    }

    @Test
    public void Email_testcase6() {
        String email = "user@example";
        Assertions.assertFalse(Email.validate(email));
    }

    @Test
    public void Email_testcase7() {
        String email = "user@example .com";
        Assertions.assertFalse(Email.validate(email));
    }
}

