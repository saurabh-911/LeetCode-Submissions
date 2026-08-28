class Solution {
    Long[][] dp;

    public long maxAlternatingSum(int[] a) {
        dp = new Long[a.length][2];
        return solve(0,1,a);
    }

    private long solve(int i, int flag, int[] a){
        if(i == a.length) return 0;

        if(dp[i][flag] != null) return dp[i][flag];

        Long notake = solve(i+1,flag,a);
        int val = (flag == 1) ? a[i] : -1 * a[i];
        Long take = solve(i+1,1-flag,a) + val;

        return dp[i][flag] = Math.max(notake, take);
    }
}