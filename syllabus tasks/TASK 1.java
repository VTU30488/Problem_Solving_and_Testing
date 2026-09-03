import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        IntStream.range(0, n)
            .map(i -> sc.nextInt() * 110 / 100)
            .forEach(x -> System.out.print(x + " "));
    }
}