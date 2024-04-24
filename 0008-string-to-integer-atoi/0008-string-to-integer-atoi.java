class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        boolean pos = s.charAt(0) == '+';        
        boolean neg = s.charAt(0) == '-';

        int ind = pos||neg?1:0;
        long ans = 0;
        for(;ind<s.length();ind++)
        {
            char ch = s.charAt(ind);
            if(ch<'0' || ch>'9') break;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (ch-'0') > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }          
            ans = ans*10 + (ch-'0');
        }
        return neg?-1*(int)ans:(int)ans;
    }
}