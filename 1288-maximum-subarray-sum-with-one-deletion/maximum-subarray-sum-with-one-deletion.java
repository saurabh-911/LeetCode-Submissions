public class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        
        int noDelete = arr[0];
        // Using a sentinel value instead of 0 to protect against negative numbers.
        // This signifies: "No deletion has happened yet."
        int oneDelete = Integer.MIN_VALUE; 
        int max_sum = arr[0];
        
        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            
            // Only calculate a choice if a valid previous state exists
            int optionB = (oneDelete == Integer.MIN_VALUE) ? Integer.MIN_VALUE : oneDelete + curr;
            int optionC = noDelete; // This is a true 1-deletion state (deleting 'curr')
            
            // Update oneDelete using clean, explicit choices
            oneDelete = Math.max(optionB, optionC);
            
            // Standard Kadane's
            noDelete = Math.max(curr, noDelete + curr);
            
            // Max sum handles your states safely
            max_sum = Math.max(max_sum, noDelete);
            if (oneDelete != Integer.MIN_VALUE) {
                max_sum = Math.max(max_sum, oneDelete);
            }
        }
        
        return max_sum;
    }
}
