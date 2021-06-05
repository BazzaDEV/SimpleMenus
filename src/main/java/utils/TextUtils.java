package utils;

import java.util.Scanner;

public class TextUtils {

    public static final String HEADER_BRACKET_STARS = "[********************************]";

    /**
     * A helper method to eliminate the redundancy of typing "System.out.println()" every time
     * a user wishes to print to the console.
     *
     * @param s the string to print to the console
     */
    public static void println(String s) {
        System.out.println(s);
    }

    /**
     * A helper method to eliminate the redundancy of typing "System.out.print()" every time
     * a user wishes to print to the console.
     * @param s the string to print to the console
     */
    public static void print(String s) {System.out.print(s);}

    /**
     * Returns a user's given input from a specified prompt.
     *
     * @param prompt a prompt for the user's input
     * @return the user's provided input
     */
    public static String getInput(String prompt) {
        print(prompt);
        return getInput();

    }

    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();

    }


    public static void printEmptyLines(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < n; i++) {
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
