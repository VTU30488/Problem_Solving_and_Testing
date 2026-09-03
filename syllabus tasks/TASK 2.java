import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // SensorID -> [sum, count]
        HashMap<String, double[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String sensor = sc.next();
            double temp = sc.nextDouble();

            // Filter temperatures greater than 50
            if (temp > 50) {
                if (!map.containsKey(sensor)) {
                    map.put(sensor, new double[]{0, 0});
                }

                map.get(sensor)[0] += temp;  // sum
                map.get(sensor)[1]++;        // count
            }
        }

        // Store SensorID and average
        ArrayList<Map.Entry<String, Double>> result = new ArrayList<>();

        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            double sum = entry.getValue()[0];
            double count = entry.getValue()[1];

            double average = sum / count;

            result.add(new AbstractMap.SimpleEntry<>(
                entry.getKey(), average
            ));
        }

        // Sort by average temperature in descending order
        result.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // Display result
        for (Map.Entry<String, Double> entry : result) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        sc.close();
    }
}