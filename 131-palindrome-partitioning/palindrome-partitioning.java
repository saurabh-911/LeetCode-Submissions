class Solution {
    private List<List<String>> ans;

    public Solution(){
        ans = new ArrayList<>();
    }

    public List<List<String>> partition(String s) {
        solve(s,0,new ArrayList());
        return ans;
    }

    private void solve(String s, int start,List<String> temp){

        if(start == s.length()){
            ans.add(new ArrayList(temp));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(validPalindrome(s, start, end)){
                temp.add(s.substring(start, end+1));
                solve(s, end+1, temp);
                temp.removeLast();
            }
        }
    }

    private boolean validPalindrome(String s, int l, int r){
        while(l<=r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}