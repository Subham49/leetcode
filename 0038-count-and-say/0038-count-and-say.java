class Solution {
    String fun(int n)
    {
        if(n == 1) return "1";
        String str = fun(n-1);
        StringBuilder sb = new StringBuilder();

        int c = 0;
        for(int i=0; i<str.length(); i++)
        {
            c++;
            if(i == str.length()-1 || str.charAt(i) != str.charAt(i+1))
            {
                sb.append(c);
                sb.append(str.charAt(i));
                c = 0;
            }
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        return fun(n);
    }
}