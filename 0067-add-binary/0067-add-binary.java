class Solution {
    public String addBinary(String a, String b) {
        StringBuilder a1 = new StringBuilder(a);
        StringBuilder b1 = new StringBuilder(b);
        a1.reverse();
        b1.reverse();
        StringBuilder ans = new StringBuilder();
        int i=0, j=0, c=0;
        while(i<a1.length() && j<b1.length())
        {
            int t = c+(a1.charAt(i)-'0')+(b1.charAt(j)-'0');
            ans.append(t%2);
            if(t>=2)
                c=1;
            else
                c=0;
            i++;
            j++;
        }
        while(i<a1.length())
        {
            int t = c+(a1.charAt(i)-'0');
            ans.append(t%2);
            if(t>=2)
                c=1;
            else
                c=0;
            i++;
        }
        while(j<b1.length())
        {
            int t = c+(b1.charAt(j)-'0');
            ans.append(t%2);
            if(t>=2)
                c=1;
            else
                c=0;
            j++;
        }
        while(c!=0)
        {
            ans.append(c%2);
            if(c>=2)
                c=1;
            else
                c=0;
        }
        return ans.reverse().toString();
    }
}