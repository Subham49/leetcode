class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    boolean fun(String s1, String s2)
    {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0) return true;
        if(s1.equals(s2)) return true;
        if(s1.length() <= 1) return false;
        int n = s1.length();
        boolean flag = false;

        String str = s1+" "+s2;

        if(map.containsKey(str))
            return map.get(str);

        for(int i=1; i<n; i++)
        {
            if(
                (fun(s1.substring(0, i), s2.substring(0, i)) && 
                fun(s1.substring(i), s2.substring(i))) ||
                (fun(s1.substring(0, i), s2.substring(n-i)) &&
                fun(s1.substring(i), s2.substring(0, n-i)))
            )
            {
                flag = true;
                break;
            }
        }
        map.put(str, flag);
        return flag;
    }
    public boolean isScramble(String s1, String s2) {
        return fun(s1, s2);
    }
}