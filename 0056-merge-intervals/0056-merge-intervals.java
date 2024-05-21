class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        list.add(intervals[0]);
        
        for(int i=1; i<intervals.length; i++)
        {
            int end = list.get(list.size()-1)[1];
            int start = intervals[i][0];
            if(start<=end)
            {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
            }
            else
            {
                list.add(intervals[i]);
            }
        }
        
        int ans[][] = new int[list.size()][2];
        for(int i=0; i<list.size(); i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }
}