import java.util.*;

public class SetBitCount {

    // Function to count the number of set bits in a given number
    public static int countBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    // Function to find the total count of set bits from 1 to N (both inclusive)
    public static int countSetBitsInRange(int N) {
        int total_count = 0;
        for (int num = 1; num <= N; num++) {
            total_count += countBits(num);
        }
        return total_count;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int N = input.nextInt();
            int result = countSetBitsInRange(N);
            System.out.println("The total count of set bits from 1 to " + N + " is: " + result);
        }
    }
}
