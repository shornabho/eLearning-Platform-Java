import java.util.Scanner;

public class ELearningApplication {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {

        while (true) {
            System.out.println("***********************");
            System.out.println("Choose Sign Up option: ");
            System.out.println("1. As Teacher");
            System.out.println("2. As Student");
            System.out.println("***********************");
            System.out.println("Enter your choice: ");
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

            takeUserInputForSignUp(user);

            System.out.println("Sign in to view information");

            takeUserInputForSignIn(user);
        }
    }

    private static void takeUserInputForSignUp(User user) {
        System.out.println("--------------------");

        if (user instanceof Student)
            System.out.println("Student Details: ");
        else if (user instanceof Teacher)
            System.out.println("Teacher Details: ");
        else
            System.out.println("User details: ");

        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter email id: ");
        String emailId = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("--------------------");

        if ( user.signUp(name, emailId, password) ) {
            System.out.println("Sign up successful!");
        }
        else {
            System.out.println("Sign up failure!");
        }


    }

    private static void takeUserInputForSignIn(User user) {
        System.out.println("--------------------");

        if (user instanceof Student)
            System.out.println("Student Details: ");
        else if (user instanceof Teacher)
            System.out.println("Teacher Details: ");
        else
            System.out.println("User details: ");

        System.out.println("Enter email id: ");
        String emailId = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("--------------------");

        if (user.signIn(emailId, password))
        {
            System.out.println("Sign In successful!");
            System.out.println("----------------------------------");
            user.viewDetails();
            System.out.println("----------------------------------");
            System.out.println();
        }
        else {
            System.out.println("Sign In failure!");
        }
    }
}
