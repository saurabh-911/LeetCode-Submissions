import java.util.HashMap;
import java.util.Map;

class Solution {
    // Using a HashMap to store previously computed step results
    private Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        return fun(0, n);
    }

    private int fun(int i, int n) {
        // Base case: if we overstep the target, this path yields 0 ways
        if (i > n) return 0;
        
        // Base case: if we reach the target exactly, we found 1 valid path
        if (i == n) return 1;

        // Cache Check: If this step was already calculated, return its stored value
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        // Recursive Breakdown: Sum the paths available by taking 1 or 2 steps
        int a1 = fun(i + 1, n);
        int a2 = fun(i + 2, n);
        int ans = a1 + a2;

        // Memoization: Save the true calculated value before returning up the stack
        dp.put(i, ans);

        return ans;
    }
}
