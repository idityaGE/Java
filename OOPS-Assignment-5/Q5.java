
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Q5 {
    /**
     * Write a Java program that takes user input for a phone number and an IP
     * address. Validate them and print whether they are valid or not.
     */

    private static final String IPADDRESS_PATTERN
            = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private static final String INDIANPHONE_PATTERN
            = "^(\\+91[ ]?|91[ ]?|[0])?[6789]\\d{9}$";

    public static boolean isValidPhoneNo(String phoneNo) {
        Pattern p = Pattern.compile(INDIANPHONE_PATTERN);
        Matcher m = p.matcher(phoneNo);
        return m.matches();
    }

    public static boolean isValidIPAddress(String IPAddress) {
        
        Pattern p = Pattern.compile(IPADDRESS_PATTERN);
        Matcher m = p.matcher(IPAddress);
        return m.matches();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your phone number :");
        String phoneNo = sc.next();
        System.out.println("Enter your IP address :");
        String IPAddress = sc.next();

        if (isValidPhoneNo(phoneNo)) {
            System.out.println("Valid Phone No. : " + phoneNo);
        } else {
            System.out.println("Not a Valid Phone No. : " + phoneNo);
        }

        if (isValidIPAddress(IPAddress)) {
            System.out.println("Valid IP address : " + IPAddress);
        } else {
            System.out.println("Not a Valid IP Address : " + IPAddress);
        }
    }
}
