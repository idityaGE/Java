
import java.util.*;

class Q4 {
    /**
     * Write a Java program that reads a list of email addresses and filter the
     * email addresses that start with a capital letter. Print the results.
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers of Emails :");
        short n = sc.nextShort();

        String emails[] = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + " Email :");
            emails[i] = sc.next();
        }

        String capEmails[] = new String[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (emails[i].length() > 0 && Character.isUpperCase(emails[i].charAt(0))) {
                capEmails[j] = emails[i];
                j++;
            }
        }

        System.out.println("Emails with uppercase first letter:");
        for (int i = 0; i < j; i++) {
            System.out.println(capEmails[i]);
        }
    }
}
