class Solution {
    int fi(int a[],int n,int k)
    {
        int lo=0, hi=n-1, mid, r=-1;
        while(lo<=hi)
        {
            mid=(lo+hi)/2;
            if(k>a[mid])
                lo=mid+1;
            else if(k<a[mid])
                hi=mid-1;
            else{
                r=mid;
                hi=mid-1;
            }
        }
        return r;
    }

    int li(int a[],int n,int k)
    {
        int lo=0, hi=n-1, mid, r=-1;
        while(lo<=hi)
        {
            mid=(lo+hi)/2;
            if(k>a[mid])
                lo=mid+1;
            else if(k<a[mid])
                hi=mid-1;
            else{
                r=mid;
                lo=mid+1;
            }
        }
        return r;
    }

    public int[] searchRange(int[] nums, int target) {
        int a[] = new int[2];
        a[0]=fi(nums,nums.length,target);
        a[1]=li(nums,nums.length,target);
        return a;
    }
}