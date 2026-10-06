import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Initialize tracking variables with the first element
        int maxSubarraySum = arr.get(0);
        int currentSubarraySum = arr.get(0);
        
        int maxSubsequenceSum = arr.get(0);

        // Iterate through the remaining elements
        for (int i = 1; i < arr.size(); i++) {
            int currentNum = arr.get(i);

            // 1. Calculate Maximum Subarray (Kadane's Algorithm)
            currentSubarraySum = Math.max(currentNum, currentSubarraySum + currentNum);
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);

            // 2. Calculate Maximum Subsequence
            // If the overall subsequence is currently negative, it's better to pick the max element seen so far
            if (maxSubsequenceSum < 0) {
                maxSubsequenceSum = Math.max(maxSubsequenceSum, currentNum);
            } else if (currentNum > 0) {
                // If we already have a positive sum, greedily add any positive numbers
                maxSubsequenceSum += currentNum;
            }
        }

        // Return the two values as a list [subarray_sum, subsequence_sum]
        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
