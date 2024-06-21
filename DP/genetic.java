public class genetic {
    public static int Genetic(String x, String y, int[][] memo) {
        int m = x.length();
        int n = y.length();

        if (m == 0 && n == 0) {
            return 0;
        }

        if (memo[m][n] != 0) {
            return memo[m][n];
        }

        if (m == 0 || n == 0) {
            return 2 * Math.max(m, n);
        }

        char a = x.charAt(0);
        char b = y.charAt(0);

        if (a == b) {
            memo[m][n] = Genetic(x.substring(1), y.substring(1), memo);
        } else {
            int ans1 = 1 + Genetic(x.substring(1), y.substring(1), memo);
            int ans2 = 2 + Genetic(x.substring(1), y, memo);
            int ans3 = 2 + Genetic(x, y.substring(1), memo);
            memo[m][n] = Math.min(ans1, Math.min(ans2, ans3));
        }

        return memo[m][n];
    }

    public static int Genetic_DP(String x, String y) {
        int[][] memo = new int[x.length() + 1][y.length() + 1];
        return Genetic(x, y, memo);
    }

    public static int Genetic_Iter(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i * 2;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j * 2;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i - 1][j - 1], Math.min(2 + dp[i - 1][j], 2 + dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String x = "AA";
        String y = "TA";
        int res = Genetic_DP(x, y);
        System.out.println(res);
    }
}
