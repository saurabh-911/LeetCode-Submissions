class Solution { 
    public int search(int[] a, int t) { 
        int n = a.length; 
        int l = 0; 
        int h = n - 1; 
        
        while (l <= h) { 
            int g = l + (h - l) / 2; 
            
            if (a[g] == t) { 
                return g; 
            } 
            
            // Check if the middle element is in the left sorted part
            if (a[g] > a[n - 1]) { 
                // Target is between the start of the left part and mid
                if (t > a[n - 1] && t < a[g]) { 
                    h = g - 1; 
                } else { 
                    l = g + 1; 
                } 
            } 
            // The middle element is in the right sorted part
            else { 
                // Target is between mid and the end of the right part
                if (t <= a[n - 1] && t > a[g]) { 
                    l = g + 1; 
                } else { 
                    h = g - 1; 
                } 
            } 
        } 
        return -1; 
    } 
}
