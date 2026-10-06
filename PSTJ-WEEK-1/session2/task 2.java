import java.io.*;
import java.util.*;

public class Solution {
    static class Student {
        int id; String name; double cgpa;
        Student(int id, String name, double cgpa) {
            this.id = id; this.name = name; this.cgpa = cgpa;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        int n = in.nextInt();
        List<Student> students = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            students.add(new Student(in.nextInt(), in.next(), in.nextDouble()));
        }
        
        students.sort((s1, s2) -> {
            if (Double.compare(s2.cgpa, s1.cgpa) != 0) {
                return Double.compare(s2.cgpa, s1.cgpa); // 1. CGPA Decreasing
            }
            if (!s1.name.equals(s2.name)) {
                return s1.name.compareTo(s2.name);       // 2. Name Alphabetical
            }
            return Integer.compare(s1.id, s2.id);         // 3. ID Ascending
        });
            
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}
