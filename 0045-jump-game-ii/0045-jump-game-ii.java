class Solution {

    public int func(int[] n, int[] dp, int i) {
        if (i == n.length - 1)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= n[i]; j++) {

            if (i + j < n.length) {

                int jumps = func(n, dp, i + j);

                if (jumps != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + jumps);
                }
            }
        }

        dp[i] = min;
        return dp[i];
    }

    public int jump(int[] n) {

        int[] dp = new int[n.length];
        Arrays.fill(dp, -1);

        return func(n, dp, 0);
    }
}