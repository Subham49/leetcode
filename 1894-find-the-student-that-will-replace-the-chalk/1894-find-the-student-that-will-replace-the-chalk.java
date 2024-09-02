class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = Arrays.stream(chalk)
                         .asLongStream()
                         .sum();
        k = (int)(k%sum);
        for(int i=0; i<chalk.length; i++)
        {
            if(chalk[i] > k) return i;
            k -= chalk[i];
        }
        return -1;
    }
}