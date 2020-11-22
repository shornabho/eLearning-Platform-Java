package ElearningPackage;

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
            System.out.println("Choose action:");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("***********************");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                User signedUpUser = takeUserInputForSignUp();
                if (signedUpUser == null) {
                    System.out.println("Sign Up failure!");
                    continue;
                }
                else {
                    System.out.println("Sign Up successful!");
                }
            }
            else if (choice == 2) {
                User signedInUser = takeUserInputForSignIn();
                if (signedInUser == null) {
                    System.out.println("Sign In failure!");
                    continue;
                }
                else {
                    System.out.println("Sign In successful!");
                    System.out.println("----------------------------------");
                    signedInUser.viewDetails();
                    System.out.println("----------------------------------");
                    System.out.println();
                }
            }
            else {
                System.out.println("Bye.");
                return;
            }


        }
    }

    private static User takeUserInputForSignUp() {
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
            return null;
        }

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
        }
        catch (EmptyFieldException e) {
            System.out.println(e.getMessage());
            System.out.println("Sign up failure!");
        }

        return user;
    }

    private static User takeUserInputForSignIn() {
        System.out.println("***********************");
        System.out.println("Choose Sign In option: ");
        System.out.println("1. As Teacher");
        System.out.println("2. As Student");
        System.out.println("***********************");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // Garbage Collection for to clear input stream for future inputs
        String garbage = sc.nextLine();

        User user = null;
        
        if (choice == 1)
        {
            user = new Teacher();
        }
        else if (choice == 2)
        {
            user = new Student();
        }

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

        

        return user;
    }
}
