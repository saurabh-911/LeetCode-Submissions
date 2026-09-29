class Solution { 
    // Changed return type to long to handle large total hours
    public long guess(int[] a, int guess){ 
        long yield = 0; // Changed from int to long to prevent overflow
        for(int ele: a){ 
            yield += ele / guess; 
            if(ele % guess != 0){ 
                yield++; 
            } 
        } 
        return yield; 
    } 

    public int minEatingSpeed(int[] a, int h) { 
        int max = Integer.MIN_VALUE; 
        for(int i=0; i<a.length; i++){ 
            max = Math.max(a[i], max); 
        } 
        
        int low = 1; 
        int high = max; 
        int ans = -1; 
        
        while(low <= high){ 
            int g = low + (high - low) / 2; 
            long k = guess(a, g); // k is now a long
            
            if(k > h){ 
                low = g + 1; 
            } else { 
                ans = g; 
                high = g - 1; 
            } 
        } 
        return ans; 
    } 
}
