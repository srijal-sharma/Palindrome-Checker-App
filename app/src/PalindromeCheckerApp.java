import java.util.Scanner;

/**
 * =====================================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * =====================================================================
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 * * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String input = sc.nextLine();

        // Capture Start Time
        long startTime = System.nanoTime();

        // Execute Palindrome Logic (Two-Pointer approach for efficiency)
        boolean isPalindrome = checkPalindrome(input);

        // Capture End Time
        long endTime = System.nanoTime();

        // Calculate Duration
        long duration = endTime - startTime;

        // Output Results
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println("Execution Time : " + duration + " ns");

        sc.close();
    }

    /**
     * Efficient iterative check to demonstrate performance.
     */
    private static boolean checkPalindrome(String str) {
        if (str == null || str.isEmpty()) return false;

        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}