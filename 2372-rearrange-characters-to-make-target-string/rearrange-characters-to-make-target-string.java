class Solution {
    public int rearrangeCharacters(String s, String target) {

        int[] stringFreq = new int[26];
        int[] targetFreq = new int[26];

        for (char ch : s.toCharArray()) 
            stringFreq[ch - 'a']++;
        

        for (char ch : target.toCharArray()) 
            targetFreq[ch - 'a']++;
        

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) 
            if (targetFreq[i] > 0) 
               ans = Math.min(ans, stringFreq[i] / targetFreq[i]);

        return ans;
    }
}