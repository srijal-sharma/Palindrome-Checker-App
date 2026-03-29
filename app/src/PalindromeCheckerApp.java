import java.util.Scanner;

/**
 * =====================================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * =====================================================================
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 * * The palindrome logic is encapsulated inside a
 * PalindromeService class.
 * * This improves:
 * - Reusability
 * - Separation of concerns
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Instantiate the Service (Object Creation)
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter string to check: ");
        String userInput = sc.nextLine();

        // Step 2: Use the service method
        boolean result = service.checkPalindrome(userInput);

        if (result) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: It is NOT a palindrome.");
        }

        sc.close();
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     * * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        // Handle null or empty inputs
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Preprocessing: logic is hidden inside this method (Encapsulation)
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize pointers (as per hint)
        int start = 0;
        int end = cleanInput.length() - 1;

        // Compare characters moving inward
        while (start < end) {
            if (cleanInput.charAt(start) != cleanInput.charAt(end)) {
                return false; // Mismatch found
            }
            start++;
            end--;
        }

        return true; // All characters matched
    }
}