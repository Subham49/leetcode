class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0)+1);

        int arr[][] = new int[map.size()][2];
        int ind = 0;
        for(int i : map.keySet())
        {
            int v = map.get(i);
            arr[ind][0] = i;
            arr[ind++][1] = v;
        }

        Arrays.sort(arr, (a,b)->{
            if(a[1] != b[1]){
                return a[1]-b[1];
            }
            return b[0] - a[0];
        });
        
        int ans[] = new int[nums.length];
        ind = 0;
        for(int i=0; i<arr.length; i++)
        {
            int k = arr[i][0];
            int v = arr[i][1];
            for(int j=0; j<v; j++)
            {
                ans[ind++] = k;
            }
        }
        return ans;
    }
}