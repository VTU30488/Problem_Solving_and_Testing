public class PrintUniquePairs {
    public static void printPairs(int[] arr) {
        int n = arr.length;
        // Outer loop selects the first element
        for (int i = 0; i < n; i++) {
            // Inner loop selects the second element (always ahead of i)
            for (int j = i + 1; j < n; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        printPairs(arr);
    }
}
