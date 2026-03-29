import java.util.Scanner;
import java.util.Stack;

/**
 * =====================================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * =====================================================================
 * Description:
 * This class demonstrates how different palindrome validation algorithms
 * can be selected dynamically at runtime using the Strategy Design Pattern.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String input = sc.nextLine();

        // 1. Define the strategy we want to use
        // In a real app, this could be chosen via a menu or config file
        PalindromeStrategy strategy = new StackStrategy();

        // 2. Execute the selected algorithm (Polymorphism in action)
        boolean result = strategy.check(input);

        System.out.println("Is Palindrome? : " + result);

        sc.close();
    }
}

/**
 * =====================================================================
 * INTERFACE - PalindromeStrategy
 * =====================================================================
 * This interface defines a contract for all palindrome checking algorithms.
 */
interface PalindromeStrategy {
    /**
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    boolean check(String input);
}

/**
 * =====================================================================
 * CLASS - StackStrategy
 * =====================================================================
 * This class provides a Stack based implementation of the PalindromeStrategy.
 * It uses LIFO behavior to reverse characters.
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;

        // Normalize for consistent results
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character onto the stack
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        // Compare characters by popping from the stack (LIFO)
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}