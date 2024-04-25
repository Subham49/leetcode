class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        
        int ans = 0;
        for(int i=0; i<s.length()-1; i++)
        {
            char curr = s.charAt(i);
            char next = s.charAt(i+1);
            if(map.get(curr) < map.get(next))
                ans -= map.get(curr);
            else
                ans += map.get(curr);
        }
        ans += map.get(s.charAt(s.length()-1));
        return ans;
    }
}