class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long temp = 0;
        
        for(int i=0; i<k; i++)
        {
            if(happiness[n-i-1] - i < 0) break;
            temp = temp + (happiness[n-i-1]) - i;
        }
        return temp;
    }
}