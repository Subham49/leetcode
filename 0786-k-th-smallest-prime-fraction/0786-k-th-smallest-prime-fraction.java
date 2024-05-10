class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0;
        double hi = 1.0;

        while(lo < hi){
            double mid = (lo + hi)/2;
            int temp[] = findFractLessThanMid(arr, mid, k);
            if(temp[0] == k) return new int[]{arr[temp[1]], arr[temp[2]]};
            else if(temp[0] > k) hi = mid;
            else lo = mid;
        }

        return new int[]{};
    }

    int[] findFractLessThanMid(int arr[], double mid, int k)
    {
        double maxLessThanMid = 0.0;
        int x = 0; //stores indices of max fraction less than mid;
        int y = 0;
            
        int total = 0;//for storing fractions less than mid
        int j = 1;
            
        for(int i=0; i<arr.length-1; i++)
        {    
            
            //while fraction is greater than mid increment j
            while(j<arr.length && arr[i]>arr[j]*mid){
                j++;
            }

            if(j == arr.length) break;

            total+=(arr.length-j); //j fractions greater than mid, n-j fractions smaller than mid, add fractions smaller than mid to total

            double fraction = (double)arr[i]/arr[j];
            if(fraction>maxLessThanMid){
                maxLessThanMid = fraction;
                x = i;
                y =j;
            }
        }
        return new int[]{total,x,y}; 
    }
}