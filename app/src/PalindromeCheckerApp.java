import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new ArrayDeque<>();

        System.out.println("===== UC7: Deque-Based Optimized Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input (remove spaces and convert to lowercase)
        String normalizedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Insert characters into deque
        for (int i = 0; i < normalizedInput.length(); i++) {
            deque.addLast(normalizedInput.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear elements
        while (deque.size() > 1) {
            char frontChar = deque.removeFirst();
            char rearChar = deque.removeLast();

            if (frontChar != rearChar) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}