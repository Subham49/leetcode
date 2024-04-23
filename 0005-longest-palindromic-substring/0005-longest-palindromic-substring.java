class Solution {
    int[] expand(String s, int i, int j)
    {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        return new int[]{i+1, j-1};
    }
    public String longestPalindrome(String s) {
        int[] ans = new int[]{0,0};
        for(int i=0; i<s.length(); i++)
        {
            int[] temp = expand(s, i, i);
            if(temp[1]-temp[0]+1>ans[1]-ans[0]+1) ans = temp;

            temp = expand(s, i, i+1);
            if(temp[1]-temp[0]+1>ans[1]-ans[0]+1) ans = temp;
        }
        return s.substring(ans[0], ans[1]+1);
    }
}