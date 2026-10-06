import java.io.*;
import java.util.*;

// Write the Arithmetic class here
class Arithmetic {
    public int add(int a, int b) {
        return a + b;
    }
}

// Write the Adder class here that inherits from Arithmetic
class Adder extends Arithmetic {
    // Inherits the add method automatically from Arithmetic
}

public class Solution {

    public static void main(String[] args) {
        // Create a new Adder object
        Adder a = new Adder();
        
        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());	
        
        // Print the result of 3 calls using the inherited add method
        System.out.print(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
    }
}
