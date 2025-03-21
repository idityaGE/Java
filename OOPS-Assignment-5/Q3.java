
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Q3 {

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
