
import java.util.*;

class Q4 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers of Emails :");
        short n = sc.nextShort();

        String emails[] = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + "Emails :");
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
