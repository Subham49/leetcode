class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int prevSmall[] = new int[n];
        Arrays.fill(prevSmall, -1);

        ArrayDeque<Integer> s = new ArrayDeque<>();

        for(int i=0; i<n; i++)
        {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i])
                s.pop();
            if(!s.isEmpty())
                prevSmall[i] = s.peek();
            s.push(i);
        }
        s = new ArrayDeque<>();

        int nextSmall[] = new int[n];
        Arrays.fill(nextSmall, n);
        for(int i=n-1; i>=0; i--)
        {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i])
                s.pop();
            if(!s.isEmpty())
                nextSmall[i] = s.peek();
            s.push(i);
        }

        int ans = 0;
        for(int i=0; i<n; i++)
        {
            ans = Math.max(ans, (nextSmall[i]-prevSmall[i]-1)*heights[i]);
        }

        return ans;
    }
}