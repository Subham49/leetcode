class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";

        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i=0; i<t.length(); i++)
        {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0)+1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        int start = 0, end = 0;
        int c = 0;
        int len = Integer.MAX_VALUE;
        String ans = s;
        while(start < s.length())
        {
            while(end<s.length() && c<t.length())
            {
                char ch = s.charAt(end);
                map2.put(ch, map2.getOrDefault(ch, 0)+1);
                if(map1.containsKey(ch) && map1.get(ch)>=map2.get(ch))
                    c++;
                end++;
            }
            String temp = s.substring(start, end);
            if(c == t.length() && len>temp.length())
            {
                ans = temp;
                len = temp.length();
            }
            char ch = s.charAt(start);
            if(map1.containsKey(ch) && map1.get(ch)>=map2.get(ch))
                c--;
            map2.put(ch, map2.get(ch)-1);
            if(map2.get(ch) == 0)
                map2.remove(ch);
            start++;
        }
        return len == Integer.MAX_VALUE? "" : ans;
    }
}