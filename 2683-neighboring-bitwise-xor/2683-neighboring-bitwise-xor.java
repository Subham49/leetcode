class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int x = 0;
        int y = 1;
        for(int i=0; i<derived.length-1; i++)
        {
            x ^= derived[i];
            y ^= derived[i];
        }
        if((x^0) == derived[derived.length-1]) return true;
        if((y^1) == derived[derived.length-1]) return true;
        return false;
    }
}