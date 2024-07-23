class Solution {
    public boolean isNumber(String s) {
        boolean exp = false;
        boolean dig = false;
        boolean dot = false;
        for(int i=0; i<s.length(); i++) 
        {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                dig = true;
            } else if (ch == '-' || ch == '+') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else if (ch == 'e' || ch == 'E') {
                if (exp || !dig)
                    return false;
                exp = true;
                dig = false;
            } else if (ch == '.') {
                if (dot || exp)
                    return false;
                dot = true;
            } else
                return false;
        }
        return dig;
    }
}