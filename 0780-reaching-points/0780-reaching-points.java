class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx>tx || sy>ty) return false;
        if(sx == tx && (ty - sy)%tx == 0) return true;
        if(sy == ty && (tx - sx)%ty == 0) return true;
        if(tx>ty) return reachingPoints(sx, sy, tx%ty, ty);        
        if(tx<ty) return reachingPoints(sx, sy, tx, ty%tx);
        return false;
    }
}