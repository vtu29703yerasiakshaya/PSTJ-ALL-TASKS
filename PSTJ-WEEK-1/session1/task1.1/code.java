import java.io.*;
import java.util.*;

public class Solution {

    static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    static boolean isPalindrome(int n) {
        int original = n;
        int reverse = 0;

        while (n != 0) {
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }

        return original == reverse;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int choice = sc.nextInt();
            int num = sc.nextInt();

            if (choice == 1) {
                if (isOdd(num))
                    System.out.println("ODD");
                else
                    System.out.println("EVEN");
            } else if (choice == 2) {
                if (isPrime(num))
                    System.out.println("PRIME");
                else
                    System.out.println("COMPOSITE");
            } else if (choice == 3) {
                if (isPalindrome(num))
                    System.out.println("PALINDROME");
                else
                    System.out.println("NOT PALINDROME");
            }
        }

        sc.close();
    }
}
