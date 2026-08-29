public static List<Integer> maxSubArray(List<Integer> arr) {
int currentSum = arr.get(0);
int maxSubarraySum = arr.get(0);

```
for (int i = 1; i < arr.size(); i++) {
    currentSum = Math.max(arr.get(i), currentSum + arr.get(i));
    maxSubarraySum = Math.max(maxSubarraySum, currentSum);
}

int maxSubsequenceSum = 0;
int maxElement = arr.get(0);

for (int num : arr) {
    if (num > 0) {
        maxSubsequenceSum += num;
    }

    maxElement = Math.max(maxElement, num);
}

if (maxSubsequenceSum == 0) {
    maxSubsequenceSum = maxElement;
}

List<Integer> result = new ArrayList<>();
result.add(maxSubarraySum);
result.add(maxSubsequenceSum);

return result;
```

}
