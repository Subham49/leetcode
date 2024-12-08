class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int arr[][] = new int[2*n][3];
        int i = 0;
        for(int event[] : events) {
            arr[2*i][0] = event[0];
            arr[2*i][1] = 1;
            arr[2*i][2] = event[2];
            arr[2*i+1][0] = event[1]+1;
            arr[2*i+1][1] = -1;
            arr[2*i+1][2] = event[2];
            i++;
        }
        Arrays.sort(arr, (a, b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        int ans = 0;
        int maxSeen = 0;
        for(int a[] : arr) {
            if(a[1] == 1){
                ans = Math.max(ans, maxSeen+a[2]);
            } else{
                maxSeen = Math.max(maxSeen, a[2]);
            }
        }
        return ans;
    }
}