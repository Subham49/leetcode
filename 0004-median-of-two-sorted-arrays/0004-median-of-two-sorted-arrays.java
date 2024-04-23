class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int nums1Size = nums1.length;
    int nums2Size = nums2.length;

    int n=nums1Size+nums2Size;
    int c[] = new int[n];
    int i=0,j=0,k=0;
    while(i<nums1Size&&j<nums2Size)
    {
        if(nums1[i]<nums2[j])
        {
            c[k++]=nums1[i++];
        }
        else{
            c[k++]=nums2[j++];
        }
    }
    while(i<nums1Size)
    {
        c[k++]=nums1[i++];
    }
    while(j<nums2Size)
    {
        c[k++]=nums2[j++];
    }
    if(n%2 == 1)
        return c[n/2];
    
    return (c[n/2]+c[n/2-1])/2.0;
        
    }
}