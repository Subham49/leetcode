class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        {
            String str[] = timePoints.get(i).split(":");
            arr[i] = Integer.valueOf(str[0])*60 + Integer.valueOf(str[1]);
        }
        Arrays.sort(arr);

        int min = 1000000;
        for(int i=1; i<n; i++)
        {
            min = Math.min(min, arr[i] - arr[i-1]);
        }
        return Math.min(min, 24*60 + arr[0] - arr[n-1]);
    }
}