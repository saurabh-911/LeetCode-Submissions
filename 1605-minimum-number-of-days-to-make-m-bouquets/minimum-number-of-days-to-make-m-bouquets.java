class Solution {
    public int guess(int[] a, int d, int k){
        int count = 0;
        int ans = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] <= d){
                count++;

                if(count >= k) {
                    ans++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return ans;
    }

    public int minDays(int[] a, int m, int k) {
        long con = 1L * k * m;
        if(con > a.length) return -1;

        int l = 1;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            max = Math.max(max, a[i]);
        }

        int h = max;
        int ans = 0;

        while(l <= h){
            int mid = l + (h-l)/2;
            int val = guess(a, mid, k);

            if(val >= m){
                ans = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}