class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums1Size = len(nums1)
        nums2Size = len(nums2)

        n=nums1Size+nums2Size;
        c = [0]*n;
        i=0
        j=0
        k=0
        while i<nums1Size and j<nums2Size:
            if nums1[i]<nums2[j]:
                c[k]=nums1[i]
                k+=1
                i+=1
            
            else:
                c[k]=nums2[j]
                k+=1
                j+=1
        
        while i<nums1Size:
            c[k]=nums1[i]
            k+=1
            i+=1
        
        while j<nums2Size:
            c[k]=nums2[j]
            k+=1
            j+=1
        
        if n%2 == 1:
            return c[n//2]

        return (c[n//2]+c[n//2-1])/2.0
