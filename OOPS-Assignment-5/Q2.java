
import java.util.*;

class Q2 {
    /**
     * Write a Java program that reads a string and prints the total number of
     * words in it. [Use split method form String class].
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string :");
        String st = sc.nextLine();

        String res[] = st.split(" ");

        System.out.println("No. of words in string : " + res.length);

    }
}
