class Solution {
    public int maxProduct(int[] a) {
        int max = -1;
        int secondMax = -1;
        for(int i=0; i<a.length; i++){
            if(max < a[i]){
                secondMax = max;
                max = a[i];
            }
            else if(secondMax < a[i]){
                secondMax = a[i];
            }
        }
        return (max-1) * (secondMax - 1);
    }
}