package Ush2;

public class Main {
    public static void main(String[] args){
        //Declare three variables of String type and assign it values.
        String str1 = "String1";
        String str2 = "String2";
        String str3 = "String3";

        //Then declare a fourth variable of type String which will be a concatenation of previously declared variables
        String concatination;
        concatination = str1 + str2 + str3;
        System.out.println("Bashkim strings menyra e pare: " + concatination);
        //Bejme reset
        concatination = "";
        concatination = concatination.concat(str1);
        concatination = concatination.concat(str2);
        concatination = concatination.concat(str3);
        System.out.println("Bashkim strings menyra e dyte: " + concatination);
    }
}
