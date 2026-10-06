import java.io.*;
import java.util.*;

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        // High CGPA first; if tied, alphabetical by name; if tied, ascending ID
        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                }
                if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                }
                return Integer.compare(s1.getID(), s2.getID());
            }
        });

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> remainingStudents = new ArrayList<>();
        while (!pq.isEmpty()) {
            remainingStudents.add(pq.poll());
        }
        return remainingStudents;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int totalEvents = Integer.parseInt(scanner.nextLine());
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- > 0 && scanner.hasNextLine()) {
            events.add(scanner.nextLine());
        }
        
        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
