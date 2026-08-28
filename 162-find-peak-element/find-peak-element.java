class Solution {
    public int findPeakElement(int[] a) {
        int l=0;
        int h=a.length-1;
        int ans = 0;
        while(l<=h){
            int m = l+(h-l)/2;
            if(m == a.length-1 || a[m] > a[m+1]){
                ans = m;
                h = m-1;
            }else{
                l = m + 1;
            }
        }
        return ans;
    }
    }
