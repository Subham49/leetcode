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
        System.out.println(list);
        
        
        return list.stream()
                   .toArray(int[][]::new);
    }
}