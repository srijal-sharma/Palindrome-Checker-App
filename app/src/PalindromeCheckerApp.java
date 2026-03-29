import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Standardize input: remove non-alphanumeric and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindrome(cleanedInput)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive method to check if a string is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        // Base Condition: If length is 0 or 1, we've successfully checked everything
        if (str.length() <= 1) {
            return true;
        }

        // Check if the first and last characters match
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            // Recursive Call: Slice the string to remove the first and last characters
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        // If characters don't match, it's not a palindrome
        return false;
    }
}