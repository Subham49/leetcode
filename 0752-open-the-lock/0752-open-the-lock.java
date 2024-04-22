class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for(String str: deadends) set.add(str);
        
        if(set.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        
        ArrayDeque<String> q = new ArrayDeque<>();
        q.add("0000");
            
        int ans = 0;
        while(!q.isEmpty())
        {
            ans++;
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                char t[] = q.remove().toCharArray();
                
                for(int j=0; j<4; j++)
                {
                    char ch = t[j];
                    t[j] = t[j] == '9'? '0' : (char)((int)t[j]+1);
                    String temp = new String(t);
                    if(temp.equals(target)) return ans;
                    if(!set.contains(temp))
                    {
                        set.add(temp);
                        q.add(temp);
                    }
                    t[j] = ch;
                    
                    t[j] = t[j] == '0'? '9' : (char)((int)t[j]-1);
                    temp = new String(t);
                    if(temp.equals(target)) return ans;
                    if(!set.contains(temp))
                    {
                        set.add(temp);
                        q.add(temp);
                    }
                    t[j] = ch;
                }
            }
        }
        return -1;
    }
}