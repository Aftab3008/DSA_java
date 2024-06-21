import java.util.Scanner;

public class bits_set {
    public static void main(String[] args) {
        int m, n;
        try (Scanner input = new Scanner(System.in)) {
            m = input.nextInt();
            n = input.nextInt();
        }
        int pos = 0;
        int a = m ^ n;
        boolean bool = true;
        boolean bools = (a ^ 1) == 0;
        while (bool) {
            if (bools) {
                pos += 1;
            }
            a >>= 1;
        }
        System.out.println(pos);

    }

}