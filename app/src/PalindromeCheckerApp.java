/**
 * ============================================================================
 * MAIN CLASS - UseCase4PalindromeCheckerApp
 * ============================================================================
 * * Use Case 4: Character Array Based Validation
 * * Description:
 * This class validates a palindrome by converting
 * the string into a character array and comparing
 * characters using the two-pointer technique.
 * * At this stage, the application:
 * - Converts string to char array
 * - Uses start and end pointers
 * - Compares characters efficiently
 * - Displays the result
 * * This reduces extra memory usage.
 * * @author Developer
 * @version 4.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC4.
     * * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System. those);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();

        // 1. Convert string to char array
        char[] charArray = input.toCharArray();

        // 2. Use two-pointer approach
        boolean isPalindrome = checkPalindrome(charArray);

        // 4. Displays the result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }

    /**
     * Logic for two-pointer comparison on a char array.
     */
    private static boolean checkPalindrome(char[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Compare characters at current pointers
            if (arr[start] != arr[end]) {
                return false; // Not a palindrome
            }
            // Move pointers towards the center
            start++;
            end--;
        }
        return true; // All characters matched
    }
}