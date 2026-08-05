class Solution {
    public int maxSubarraySumCircular(int[] a) {
        int n = a.length;
        
        // Initializations using the first element
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

// [-3, -2, -5] 
// totalSum = -10 
// minSum = -10 
// formula: totalSum - minSum
        //  (-10)-(-10)= (0)      

        // The Solution:
        // If you must pick at least one negative number, the best strategy is to pick the single largest negative number (the one closest to zero).
        
        // Since maxSum runs standard Kadane's, it has already found that exact number for you (in this case, -2). Returning maxSum ensures you return a valid, non-empty subarray sum.  

        if (maxSum < 0) {
            return maxSum;
        }

        // Final answer: Max of non-circular (maxSum) and circular configurations
        int ans = Math.max(maxSum, totalSum - minSum);
        return ans;
    }
}
