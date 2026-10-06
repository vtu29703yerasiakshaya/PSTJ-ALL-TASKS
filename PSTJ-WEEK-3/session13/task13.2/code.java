import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        // Dynamic nested list to handle varying line lengths
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            ArrayList<Integer> currentLine = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                currentLine.add(scanner.nextInt());
            }
            lines.add(currentLine);
        }
        
        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();
        
        for (int k = 0; k < q; k++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            // Adjust 1-based index from input to 0-based index for ArrayList
            int lineIndex = x - 1;
            int positionIndex = y - 1;
            
            // Validate bounds to prevent IndexOutOfBoundsException
            if (lineIndex >= 0 && lineIndex < lines.size() && 
                positionIndex >= 0 && positionIndex < lines.get(lineIndex).size()) {
                System.out.println(lines.get(lineIndex).get(positionIndex));
            } else {
                System.out.println("ERROR!");
            }
        }
        
        scanner.close();
    }
}
