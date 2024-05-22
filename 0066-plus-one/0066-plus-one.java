class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i : digits)
            list.add(i);
        Collections.reverse(list);
        int c = 1;
        for(int i=0; i<digits.length; i++)
        {
            int t = (list.get(i)+c)%10;
            c = (list.get(i)+c)/10;
            list.set(i, t);
        }
        if(c!=0)
            list.add(c);
        Collections.reverse(list);
        int ans[] = new int[list.size()];
        for(int i=0; i<list.size(); i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }
}