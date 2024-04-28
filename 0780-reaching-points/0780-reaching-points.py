class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        if sx>tx or sy>ty: return False;
        
        if tx == sx and (ty - sy)%tx == 0 : return True
        if ty == sy and (tx - sx)%ty == 0 : return True
        
        if tx>ty: return self.reachingPoints(sx, sy, tx%ty, ty)
        if tx<ty: return self.reachingPoints(sx, sy, tx, ty%tx)
        
        return False