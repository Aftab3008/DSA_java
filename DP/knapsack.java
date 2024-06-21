public class knapsack {
    public static int knapsack_Recu(int W, int val[], int wt[], int i) {
        int ans;
        if (i == val.length) {
            return 0;
        }
        if (wt[i] <= W) {
            int ans1 = val[i] + knapsack_Recu(W - wt[i], val, wt, i + 1);
            int ans2 = knapsack_Recu(W, val, wt, i + 1);
            ans = Math.max(ans1, ans2);
        } else {
            ans = knapsack_Recu(W, val, wt, i + 1);
        }
        return ans;
    }

    // public static int knapsack_Iter(int W, int val[], int wt[]) {
    // int n = val.length;
    // int[][] dp = new int[n + 1][W + 1];
    // for (int i = n - 1; i >= 0; i--) {
    // for (int j = W - 1; j >= 0; j--) {

    // }
    // }
    // }

    public static void main(String[] args) {
        int val[] = { 200, 300, 100 }, wt[] = { 20, 25, 30 };
        int W = 50;
        System.out.println(knapsack_Recu(W, val, wt, 0));
    }
}
