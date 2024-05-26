class Solution {
    int fun(int arr[])
    {
        int n = arr.length;
        int prev[] = new int[n];
        Arrays.fill(prev, -1);
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(int i=0; i<n; i++)
        {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
                s.pop();
            if(!s.isEmpty())
                prev[i] = s.peek();
            s.push(i);
        }
        s = new ArrayDeque<>();
        int next[] = new int[n];
        Arrays.fill(next, n);
        for(int i=n-1; i>=0; i--)
        {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
                s.pop();
            if(!s.isEmpty())
                next[i] = s.peek();
            s.push(i);
        }

        int ans = 0;
        for(int i=0; i<n; i++)
        {
            ans = Math.max(ans, arr[i]*(next[i]-prev[i]-1));
        }

        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int a[] = new int[matrix[0].length];
        int ans = 0;

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == '0')
                    a[j] = 0;
                else
                    a[j] += matrix[i][j]-'0';
            }
            ans = Math.max(ans, fun(a));
        }

        return ans;
    }
}