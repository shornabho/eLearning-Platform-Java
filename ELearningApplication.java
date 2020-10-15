import java.util.Scanner;
import java.io.Console;

public class ELearningApplication {
    static Scanner sc = new Scanner(System.in);
    static Console console = System.console();

    public static void main(String[] args) {
        if (args.length < 1)
        {
            System.out.println("Please enter username as command-line argument. No spaces are allowed.");
        }
        else if (args.length > 1) {
            System.out.println("Expected 1 argument, got more.");
        }
        else {
            System.out.println("\n--------------------------------- Hello, " + args[0] + " ---------------------------------\n");
            showMenu();
        }
    }

    private static void showMenu() {
        while (true) {
            System.out.println("***********************");
            System.out.println("Choose Sign Up option: ");
            System.out.println("1. As Teacher");
            System.out.println("2. As Student");
            System.out.println("***********************");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            // Garbage Collection for to clear input stream for future inputs
            String garbage = sc.nextLine();

            User user;

            if (choice == 1)
            {
                user = new Teacher();
            }
            else if (choice == 2)
            {
                user = new Student();
            }
            else {
                System.out.println("Bye.");
                break;
            }

            User signedUpUser = takeUserInputForSignUp(user);

            System.out.println("Sign in to view information");

            User signedInUser = takeUserInputForSignIn(user);


            System.out.println("----------------------------------");
            signedInUser.viewDetails();
            System.out.println("----------------------------------");
            System.out.println();
        }
    }

    private static User takeUserInputForSignUp(User user) {
        System.out.println("--------------------");

        if (user instanceof Student)
            System.out.println("Student Details: ");
        else if (user instanceof Teacher)
            System.out.println("Teacher Details: ");
        else
            System.out.println("User details: ");

        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter email id: ");
        String emailId = sc.nextLine();
        char[] passwordChars = console.readPassword("Enter password: ");
        String password = new String(passwordChars);
        System.out.println("--------------------");

        try
        {
            if (user instanceof Student)
                user = Student.signUp(firstName, lastName, emailId, password);
            else if (user instanceof Teacher)
                user = Teacher.signUp(firstName, lastName, emailId, password);
            else
                user = User.signUp(firstName, lastName, emailId, password);

            if (user != null)
                System.out.println("Sign up successful!");
            else
                System.out.println("Sign up failure!");
        }
        catch (EmptyFieldException e) {
            System.out.println(e.getMessage());
            System.out.println("Sign up failure!");
        }

        return user;
    }

    private static User takeUserInputForSignIn(User user) {
        System.out.println("--------------------");

        if (user instanceof Student)
            System.out.println("Student Details: ");
        else if (user instanceof Teacher)
            System.out.println("Teacher Details: ");
        else
            System.out.println("User details: ");

        System.out.print("Enter email id: ");
        String emailId = sc.nextLine();
        char[] passwordChars = console.readPassword("Enter password: ");
        String password = new String(passwordChars);
        System.out.println("--------------------");

        if (user instanceof Student)
            user = Student.signIn(emailId, password);
        else if (user instanceof Teacher)
            user = Teacher.signIn(emailId, password);
        else
            user = User.signIn(emailId, password);

        if (user != null)
        {
            System.out.println("Sign In successful!");
        }
        else {
            System.out.println("Sign In failure!");
        }

        return user;
    }
}
