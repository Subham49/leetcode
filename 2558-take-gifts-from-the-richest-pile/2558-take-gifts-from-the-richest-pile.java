class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i : gifts)
        {
            q.add((long)i);
        }
        while(k!=0)
        { 
            q.add((long)Math.sqrt(q.peek()));
            q.remove();
            k--;
        }
        long ans = 0;
        while(!q.isEmpty())
        {
            ans += q.peek();
            q.remove();
        }
        return ans;
    }
}