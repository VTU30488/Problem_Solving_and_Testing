import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String username = sc.next();
            String password = sc.next();

            // Boundary value and edge case validation
            if (username.length() >= 3 && username.length() <= 20 &&
                password.length() >= 6 && password.length() <= 20) {

                System.out.println("SUCCESS");

            } else {
                System.out.println("FAILURE");
            }
        }

        sc.close();
    }
}