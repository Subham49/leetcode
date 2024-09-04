class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int f = 0;
        int ans = 0;
        HashSet<String> obs = new HashSet<>();
        for(int []i : obstacles) obs.add(i[0]+"$"+i[1]);
    
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0; i<commands.length; i++)
        {
            int com = commands[i];
            if(com == -1) 
                f = (f+1)%4;
            else if(com == -2)
                f = (4+f-1)%4;
            else{
                while(com --> 0 && !obs.contains((x+dir[f][0])+"$"+(y+dir[f][1])))
                {
                    x += dir[f][0];
                    y += dir[f][1];
                }
            }
            ans = Math.max(ans, x*x + y*y);
        }
        return ans;
    }
}