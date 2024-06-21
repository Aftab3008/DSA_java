public class LCS {
    public static void main(String[] args) {
        String str1 = "bedgmc";
        String str2 = "abdfglc";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = Longest_com_str(str1, str2, 0, 0);
        int ans1 = Longest_com_str_Memo(str1, str2, 0, 0, dp);
        System.out.println(LCS_iterative(str1, str2));
        System.out.println(ans);
        System.out.println(ans1);
    }

    public static int Longest_com_str(String str1, String str2, int i, int j) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + Longest_com_str(str1, str2, i + 1, j + 1);
        } else {
            int a = Longest_com_str(str1, str2, i + 1, j);
            int b = Longest_com_str(str1, str2, i, j + 1);
            return Math.max(a, b);
        }
    }

    public static int Longest_com_str_Memo(String str1, String str2, int i, int j, int[][] dp) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }
        int myAns;
        if (str1.charAt(i) == str2.charAt(j)) {
            int smallAns;
            if (dp[i + 1][j + 1] == -1) {
                smallAns = Longest_com_str(str1, str2, i + 1, j + 1);
                dp[i + 1][j + 1] = smallAns;
            } else {
                smallAns = dp[i + 1][j + 1];
            }
            myAns = 1 + smallAns;
        } else {
            int a, b;
            if (dp[i + 1][j] == -1) {
                a = Longest_com_str(str1, str2, i + 1, j);
                dp[i + 1][j] = a;
            } else {
                a = dp[i + 1][j];
            }
            if (dp[i][j + 1] == -1) {
                b = Longest_com_str(str1, str2, i, j + 1);
                dp[i][j + 1] = b;
            } else {
                b = dp[i][j + 1];
            }
            myAns = Math.max(a, b);
        }
        return myAns;
    }

    public static int LCS_iterative(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            int ans;
            for (int j = n - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    ans = dp[i + 1][j + 1] + 1;
                } else {
                    ans = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}
