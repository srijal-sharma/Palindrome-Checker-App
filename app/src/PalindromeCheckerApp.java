/**
 * ============================================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ============================================================================
 * * Use Case 6: Queue + Stack Fairness Check
 * * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 * * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 * * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 * * If all characters match, the input string is confirmed
 * as a palindrome.
 * * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 * * @author Developer
 * @version 6.0
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC6.
     * * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to validate (UC6 - Stack/Queue): ");
        String input = scanner.nextLine();

        // Initialize both data structures
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // 1. Enqueue and Push characters
        for (char c : input.toCharArray()) {
            stack.push(c);   // LIFO
            queue.add(c);    // FIFO
        }

        boolean isPalindrome = true;

        // 2. Compare dequeue vs pop
        // The queue provides the original sequence, the stack provides the reverse.
        while (!stack.isEmpty()) {
            char fromStack = stack.pop();
            char fromQueue = queue.remove();

            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }

        // 3. Displays the result
        if (isPalindrome) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}