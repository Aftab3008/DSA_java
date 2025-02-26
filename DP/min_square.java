import java.util.Scanner;

public class min_square {
    public static int minsquare(int n, int dp[]) {
        if (n == 0) {
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int currAns;
            if (dp[n - (i * i)] == -1) {
                currAns = minsquare(n - (i * i), dp);
                dp[n - (i * i)] = currAns;
            } else {
                currAns = dp[n - (i * i)];
            }
            if (minAns > currAns) {
                minAns = currAns;
            }
        }
        return 1 + minAns;
    }

    public static int minsquare_Iterative(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minAns = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int currAns = dp[i - (j * j)];
                if (minAns > currAns) {
                    minAns = currAns;
                }
            }
            dp[i] = minAns + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n = input.nextInt();
            int dp[] = new int[n + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = -1;
            }
            System.out.println(minsquare(n, dp));
            System.out.println(minsquare_Iterative(n));
        }
    }
}
