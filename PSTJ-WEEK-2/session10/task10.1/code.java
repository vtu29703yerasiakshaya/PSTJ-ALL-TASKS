import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>(); // Tracks element frequencies
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // 1. Insert the incoming element
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            // 2. Process when the sliding window reaches size M
            if (deque.size() == m) {
                // Update the maximum unique count found so far
                if (map.size() > maxUnique) {
                    maxUnique = map.size();
                }
                
                // Early exit optimization: maximum unique elements cannot exceed window size M
                if (maxUnique == m) {
                    System.out.println(maxUnique);
                    return; 
                }
                
                // 3. Slide the window: remove the oldest element from the front
                int first = deque.removeFirst();
                int count = map.get(first);
                if (count == 1) {
                    map.remove(first);
                } else {
                    map.put(first, count - 1);
                }
            }
        }
        
        System.out.println(maxUnique);
    }
}
