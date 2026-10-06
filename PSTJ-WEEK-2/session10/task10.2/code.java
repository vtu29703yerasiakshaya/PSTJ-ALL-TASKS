import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int t = s.nextInt();
            HashSet<String> set = new HashSet<>();
            while (t-- > 0 && s.hasNext()) {
                set.add(s.next() + " " + s.next());
                System.out.println(set.size());
            }
        }
    }
}
