
import java.util.*;

class Q1 {
    /**
     * Write a java program to extract the username from given email address and
     * verify that the domain of given email address if “gmail.com”.
     */
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your email :");
            String email = sc.next();

            String res[] = email.split("@");

            System.out.print("Username :");
            System.out.println(res[0]);

            if (res[1].equals("gmail.com")) {
                System.out.println("Domain of given email address is “gmail.com”.");
                System.out.println(res[1]);
            }
        }
    }
}
