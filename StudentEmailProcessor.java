import java.util.Scanner;

public class StudentEmailProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's email address: ");
        String rawEmail = scanner.nextLine();

        System.out.println("\n--- String Operations Results ---");
       
        System.out.println("1. Length of entered email (including any spaces): " + rawEmail.length());

        String email = rawEmail.trim();
        System.out.println("9. Trimmed email address: \"" + email + "\" (Length after trim: " + email.length() + ")");

        int atIndex = email.indexOf('@');
        if (atIndex > 0 && atIndex < email.length() - 1) {
            String username = email.substring(0, atIndex);
            System.out.println("2. Username: " + username);

            String domain = email.substring(atIndex + 1);
            System.out.println("3. Domain name: " + domain);
            if (domain.equals("bmsce.ac.in")) {
                System.out.println("   -> Verification: Valid BMSCE institutional domain.");
            } else {
                System.out.println("   -> Verification: Does NOT belong to bmsce.ac.in.");
            }
        } else {
            System.out.println("2 & 3. Invalid email format: Missing or misplaced '@' symbol.");
        }

        String lowerEmail = email.toLowerCase();
        System.out.println("4. Lowercase email: " + lowerEmail);

        System.out.print("\nEnter a prefix to check (e.g., registration number): ");
        String prefix = scanner.nextLine().trim();
        if (email.startsWith(prefix)) {
            System.out.println("5. Prefix check: The email starts with \"" + prefix + "\".");
        } else {
            System.out.println("5. Prefix check: The email does NOT start with \"" + prefix + "\".");
        }

        boolean endsWithDomain = email.endsWith("bmsce.ac.in");
        System.out.println("6. Ends with \"bmsce.ac.in\": " + endsWithDomain);

        String updatedEmail = email.replace("bmsce.ac.in", "cse.bmsce.ac.in");
        System.out.println("7. Updated email (department domain): " + updatedEmail);

        System.out.print("\nEnter a character or sequence to search for (e.g., \"cse\" or \"2025\"): ");
        String sequence = scanner.nextLine();
        boolean containsSeq = email.contains(sequence);
        System.out.println("8. Contains \"" + sequence + "\": " + containsSeq);

        System.out.print("\nEnter a second email address to compare: ");
        String secondEmail = scanner.nextLine().trim();
        if (email.equalsIgnoreCase(secondEmail)) {
            System.out.println("10. Comparison: Both email addresses are identical (ignoring case).");
        } else {
            System.out.println("10. Comparison: The email addresses are different.");
        }

        scanner.close();
    }
}
