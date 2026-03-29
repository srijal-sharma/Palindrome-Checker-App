import java.util.Scanner;

public class PalindromeCheckerApp { public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("--- UC9: Recursive Palindrome Checker ---");
    System.out.print("Enter string: ");
    String input = sc.nextLine();

    // Standardizing the input (removing spaces/casing) for accurate checking
    String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    // Initial recursive call: start at 0 and end at length - 1
    boolean isPalindrome = check(cleanInput, 0, cleanInput.length() - 1);

    if (isPalindrome) {
        System.out.println("Result: \"" + input + "\" is a palindrome.");
    } else {
        System.out.println("Result: \"" + input + "\" is not a palindrome.");
    }

    sc.close();
}
    private static boolean check(String s, int start, int end) {
        // Base Condition: If pointers cross or meet, all characters matched
        if (start >= end) {
            return true;
        }

        // Recursive Step: Compare characters at start and end
        if (s.charAt(start) == s.charAt(end)) {
            // Recursive call moves the pointers inward
            return check(s, start + 1, end - 1);
        }

        // Mismatch found
        return false;
    }

}