class Solution {
    public int findMin(int[] a) {
        int n = a.length;
        int l =0;
        int h = n-1;
        int ans = Integer.MAX_VALUE;

        // while(l<=h){
        //     int m = (l+h)/2;

        //     if(m == n-1) return a[0];

        //     if(a[m] > a[m+1]) {
        //         return a[m+1];
        //     }
        //     else {
        //         ans = Math.min(a[m], ans);
        //          h = m-1;
        //     }

        while(l<=h){
            int guess = (l+h)/2;
            if(a[guess] > a[n-1]){
                l = guess + 1;
            }else{
                ans = guess;
                h = guess - 1;
            }
        }
                return a[ans];
        }
    }
