class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++)
        {
            list.add(new ArrayList<>());
        }
        int i=0, k=0;
        boolean flag = true;
        while(i<s.length())
        {
            if(flag)
            {
                while(i<s.length() && k<numRows)
                {
                    list.get(k).add(s.charAt(i++));
                    k++;
                }
                k = numRows-2;
            }
            else{
                while(i<s.length() && k>=0)
                {
                    list.get(k).add(s.charAt(i++));
                    k--;
                }
                k = 1;
            }
            flag = !flag;
        }
        StringBuilder ans = new StringBuilder();
        for(ArrayList<Character> str : list)
        {
            for(Character ch : str)
            {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}