import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();
            int[] count = new int[26];

            int leftEnd = n / 2;

            for (int i = 0; i < leftEnd; i++) {
                count[s.charAt(i) - 'a']++;
            }

            int rightStart = (n % 2 == 0) ? n / 2 : n / 2 + 1;

            for (int i = rightStart; i < n; i++) {
                count[s.charAt(i) - 'a']--;
            }

            boolean lapindrome = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    lapindrome = false;
                    break;
                }
            }

            System.out.println(lapindrome ? "YES" : "NO");
        }

        sc.close();
    }
}