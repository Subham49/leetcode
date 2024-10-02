class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 1;
        for(int i = 0; i<copy.length; i++)
        {
            if(map.containsKey(copy[i])) continue;
            map.put(copy[i], r++);
        }
        for(int i=0; i<copy.length; i++)
        {
            copy[i] = map.get(arr[i]);
        }
        return copy;
    }
}