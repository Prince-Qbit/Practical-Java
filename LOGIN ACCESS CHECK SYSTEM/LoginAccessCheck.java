import java.util.Scanner;

public class LoginAccessCheck {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            String correctUsername = "admin";
            String correctPassword = "10249";
            
            System.out.print("Enter username: ");
            String username = input.nextLine();
            
            System.out.print("Enter password: ");
            String password = input.nextLine();
            
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Access Granted");
            } else {
                System.out.println("Access Denied");
            }
        }
    }
}
