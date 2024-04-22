class Solution {
    public int reverse(int x) {
        boolean sign = x>=0;
        
        StringBuilder str = new StringBuilder(Math.abs(x)+"");
        str.reverse();
        try{
            return sign ? Integer.valueOf(str.toString()) : -Integer.valueOf(str.toString());
        }
        catch(Exception e){
            return 0;
        }
    }
}