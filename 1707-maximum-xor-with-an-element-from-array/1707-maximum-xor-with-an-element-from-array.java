class TrieNode{
    TrieNode[] children;

    TrieNode()
    {
        children = new TrieNode[2];
    }
}

class Solution {
    TrieNode root = new TrieNode();
    
    void insert(int n)
    {
        TrieNode curr = root;
        
        for(int i=31; i>=0; i--)
        {
            int bit = (n>>i)&1;
            if(curr.children[bit] == null)
            {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }
    
    int fun(int n)
    {
        TrieNode curr = root;
        int ans = 0;
        for(int i=31; i>=0; i--)
        {
            int bit = (n>>i)&1;
            if(curr.children[bit^1] != null)
            {
                ans = ans | 1<<i;
                curr = curr.children[bit^1];
            }else if(curr.children[bit] != null)
                curr = curr.children[bit];
            else return -1;
            
        }
        return ans;
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        
        int ans[] = new int[queries.length];
        
        Arrays.sort(nums);
        int temp[][] = new int[queries.length][3];
        
        int i = 0;
        for(int q[] : queries){
            temp[i][0] = q[0];
            temp[i][1] = q[1];
            temp[i][2] = i++;
        }
        
        Arrays.sort(temp, (a, b)->a[1]-b[1]);
        
        i = 0;
        for(int q[] : temp)
        {
            while(i < n && nums[i]<=q[1]) insert(nums[i++]);
            ans[q[2]] = fun(q[0]);
        }
        return ans;
    }
}