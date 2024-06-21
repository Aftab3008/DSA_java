import java.util.Scanner;

public class minsteps_to_one {
    public static int minStepsTo1(int n, int dp[]) {
        if (n == 1) {
            return 0;
        }
        int ans1 = Integer.MAX_VALUE;
        if (dp[n - 1] == -1) {
            ans1 = minStepsTo1(n - 1, dp);
            dp[n - 1] = ans1;
        } else {
            ans1 = dp[n - 1];
        }
        int ans2 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            if (dp[n / 2] == -1) {
                ans2 = minStepsTo1(n / 2, dp);
            } else {
                ans2 = dp[n / 2];
            }
        }
        int ans3 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            if (dp[n / 3] == -1) {
                ans3 = minStepsTo1(n / 3, dp);
            } else {
                ans3 = dp[n / 3];
            }
        }
        return Math.min(ans1, Math.min(ans2, ans3)) + 1;
    }

    public static int minStepsTo1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
            }
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
            System.out.println(minStepsTo1(n, dp));
            System.out.println(minStepsTo1(n));
        }
    }
}
