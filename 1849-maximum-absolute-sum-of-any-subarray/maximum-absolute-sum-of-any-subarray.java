class Solution {
    public int maxAbsoluteSum(int[] a) {
        int n = a.length;
        
        int bestendingMax = a[0];
        int maxSum = a[0];

        int bestendingMin = a[0];
        int minSum = a[0];

        int totalSum = a[0];
        
        for (int i = 1; i < n; i++) {
            totalSum += a[i]; 

            // 1. Maximum Subarray Sum Calculation
            int joinMax = bestendingMax + a[i];
            int sepMax = a[i];
            bestendingMax = Math.max(joinMax, sepMax);
            maxSum = Math.max(maxSum, bestendingMax);

            // 2. Minimum Subarray Sum Calculation
            int joinMin = bestendingMin + a[i];
            int sepMin = a[i];
            bestendingMin = Math.min(joinMin, sepMin);
            minSum = Math.min(minSum, bestendingMin);
        }

        int ans = Math.max(maxSum, Math.abs(minSum));
        return ans;
    }
}
