class Solution {
    int[] fill(int r, int c, int land[][])
    {
        int i = r;
        while(i < land.length && land[i][c] == 1) i += 1;
        int j = c;
        while(j < land[0].length && land[r][j] == 1) j += 1;
        for(int r1 = r; r1<i; r1++)
        {
            for(int c1 = c; c1<j; c1++)
            {
                land[r1][c1] = 2;
            }
        }
        return new int[]{i-1, j-1};
    }

    public int[][] findFarmland(int[][] land) {
        int r = land.length;
        int c = land[0].length;

        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(land[i][j] == 1)
                {
                    int[] temp = fill(i, j, land);
                    list.add(new int[]{i, j, temp[0], temp[1]});
                }
            }
        }
        
        int ans[][] = new int[list.size()][4];
        int i = 0;
        for(int[] l : list){
            ans[i][0] = l[0];
            ans[i][1] = l[1];
            ans[i][2] = l[2];
            ans[i][3] = l[3];
            i++;
        }
        
        
        // return list.stream()
        //            .toArray(int[][]::new);
        return ans;
    }
}