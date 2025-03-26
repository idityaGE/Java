
import java.util.Scanner;

public class Q7 {
    /**
     * Input a paragraph from any book, and write the java program to count the
     * occurrence of any given word in the paragraph.
     */

    public static int countWordOccurrences(String text, String word) {
        String[] words = text.split("\\s+|[.,!?;]");
        int count = 0;

        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the paragraph:");
        String paragraph = sc.nextLine();

        System.out.println("Enter the word to count:");
        String word = sc.next();

        int count = countWordOccurrences(paragraph, word);

        System.out.println("The word '" + word + "' occurs " + count + " times in the paragraph.");
    }
}
