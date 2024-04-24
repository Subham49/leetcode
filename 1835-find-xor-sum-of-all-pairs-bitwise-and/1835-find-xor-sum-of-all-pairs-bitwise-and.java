class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xorArr2 = 0;
        for(int i : arr2) xorArr2 ^= i;
        int xorArr1 = 0;
        for(int j : arr1) xorArr1 ^= j;
        return xorArr2 & xorArr1;
    }
}