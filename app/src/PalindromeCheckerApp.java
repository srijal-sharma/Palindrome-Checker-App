import java.util.Scanner;

public class PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC8: Linked List Based Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input (remove spaces and convert to lowercase)
        String normalizedInput = input.replaceAll("\\s+", "").toLowerCase();

        if (normalizedInput.length() == 0) {
            System.out.println("Result: The given string is a Palindrome.");
            scanner.close();
            return;
        }

        // Step 1: Convert string to linked list
        Node head = new Node(normalizedInput.charAt(0));
        Node current = head;

        for (int i = 1; i < normalizedInput.length(); i++) {
            current.next = new Node(normalizedInput.charAt(i));
            current = current.next;
        }

        // Step 2: Find middle using fast and slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node secondHalf = reverseList(slow);

        // Step 4: Compare first half and reversed second half
        Node firstHalf = head;
        Node tempSecondHalf = secondHalf;
        boolean isPalindrome = true;

        while (tempSecondHalf != null) {
            if (firstHalf.data != tempSecondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecondHalf = tempSecondHalf.next;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Method to reverse linked list
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}