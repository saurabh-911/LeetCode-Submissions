class Solution {
    private int ans;
    private Map<Integer, Integer> map;

    Solution(){
        ans = 0;
        map = new HashMap<>();
    }

    public int climbStairs(int n) {
        solve(0, n);
        return ans;
    }

    private void solve(int temp, int target){
        if(temp > target) {
                return;
            }
        if(temp == target){
            ans += 1;
            return;
        }

        if(map.containsKey(temp+1)) {
            ans += map.get(temp+1);  
        }else{
        int prevAns = ans;
        solve(temp + 1, target);
        int paths = ans - prevAns; // total ans via solve(temp + 1, target); alone
        map.put(temp+1, paths);
        }

        if(map.containsKey(temp+2)) {
            ans += map.get(temp+2);
        }else{
        int prevAns = ans;
        solve(temp + 2, target);
        int paths = ans - prevAns; // total ans via solve(temp + 2, target); alone
        map.put(temp+2, paths);
        }
    }
}