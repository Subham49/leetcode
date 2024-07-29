class Solution {
    public int numTeams(int[] arr) {
        int i = 0, j = 0, k = 0, small = 0, large = 0, ans = 0;

        for (i = 1; i < arr.length - 1; i++) {
            small = 0;
            large = 0;
            for (j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j])
                    small++;
            }
            for (k = i + 1; k < arr.length; k++) {
                if (arr[i] < arr[k])
                    large++;
            }

            ans += (small * large) + ((i - small) * (arr.length - i - 1 - large));
        }

        return ans;
    }
}