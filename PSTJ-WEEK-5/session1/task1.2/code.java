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
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        // Handle cases where chocolate bar is smaller than the required window
        if (s.size() < m) {
            return 0;
        }

        int count = 0;
        int currentSum = 0;

        // Calculate sum for the very first window of length m
        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }

        // Check if the initial window matches Ron's birth day
        if (currentSum == d) {
            count++;
        }

        // Use the sliding window technique for the rest of the elements
        for (int i = m; i < s.size(); i++) {
            // Add the new element entering the window
            // Subtract the old element leaving the window
            currentSum += s.get(i) - s.get(i - m);

            // Check if the newly updated window matches Ron's birth day
            if (currentSum == d) {
                count++;
            }
        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
