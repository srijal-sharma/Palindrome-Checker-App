/**
 * ============================================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ============================================================================
 * * Use Case 5: Stack Based Palindrome Checker
 * * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 * * At this stage, the application:
 * - Pushes characters into a stack
 * - Pops them in reverse order
 * - Compares with original sequence
 * - Displays the result
 * * This maps stack behavior to reversal logic.
 * * @author Developer
 * @version 5.0
 */

import java.util.Stack;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC5.
     * * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Declare and initialize the input string.
        String input = "noon";

        // Create a Stack to store characters.
        Stack<Character> stack = new Stack<>();

        // 1. Push each character of the string into the stack.
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially.
        boolean isPalindrome = true;

        // 2. Pop and compare
        // We iterate through the original string again and compare
        // each character with the top of the stack (which is the end of the string).
        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);
            char reversedChar = stack.pop();

            if (originalChar != reversedChar) {
                isPalindrome = false;
                break;
            }
        }

        // 3. Print result
        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }
    }
}