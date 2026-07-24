class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[26];

        for(int i=0; i<text.length(); i++) 
                   map[text.charAt(i) - 'a']++;

        return Math.min(map['b' - 'a'],
               Math.min(
                Math.min(map['a' - 'a'],map['l' - 'a']/2), 
                Math.min(map['o' - 'a']/2, map['n' - 'a']))
                );
    }
}