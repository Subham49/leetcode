class Solution {
    public int numSteps(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 1)
        {
            int n = sb.length()-1;
            if(sb.charAt(n) == '0') sb.deleteCharAt(n);
            else{
                while(n >= 0 && sb.charAt(n) == '1') sb.setCharAt(n--, '0');
                if(n < 0) sb.insert(0, '1');
                else sb.setCharAt(n, '1');
            }
            ans++;
        }
        return ans;
    }
}