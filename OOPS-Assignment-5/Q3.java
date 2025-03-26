
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Q3 {
    /**
     * Write a Java program that reads a string and find that if it is a binary
     * sequence of 0s and 1s or not.
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string :");
        String st = sc.next();

        String rejex = "[0-1]+";

        Pattern p = Pattern.compile(rejex);

        Matcher m = p.matcher(st);

        boolean isMatching = m.matches();
        System.out.println(isMatching);

    }
}
