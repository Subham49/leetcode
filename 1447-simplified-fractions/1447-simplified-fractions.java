class Solution {
    int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    public List<String> simplifiedFractions(int n) {
        HashSet<String> set = new HashSet<>();
        for(int i=1; i<n; i++)
        {
            for(int j=i+1; j<=n; j++)
            {
                int gcd = findGCD(i, j);
                if(gcd==1)
                    set.add(i+"/"+j);
            }
        }
        return new ArrayList<>(set);
    }
}