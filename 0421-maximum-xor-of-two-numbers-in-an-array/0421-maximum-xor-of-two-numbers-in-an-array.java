class TrieNode{
    TrieNode[] children;

    TrieNode()
    {
        children = new TrieNode[2];
    }
}

class Solution {
    TrieNode root;
    
    public Solution() 
    {
        root = new TrieNode();
    }
    
    public int findMaximumXOR(int[] nums) {
        
        for(int num : nums)
        {
            TrieNode curr = root;
            for(int i=31; i>=0; i--)
            {
                int bit = (num&(1<<i))>0?1:0;
                
                if(curr.children[bit] == null)
                {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit];
            }
        }
        
        int ans = 0;
        
        for(int num : nums)
        {
            TrieNode curr = root;
            int temp = 0;
            for(int i=31; i>=0; i--)
            {
                int bit = (num&(1<<i))>0?0:1;
                
                if(curr.children[bit] == null)
                {
                    bit = bit == 0?1:0;
                }
                temp = temp<<1 | bit;
                curr = curr.children[bit];
            }
            ans = Math.max(ans, num ^ temp);
        }
        return ans;
    }
}