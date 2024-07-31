class Solution {

    public int recur(int idx, int currWidth, int height, int[][] books, int shelfWidth, Integer[][] memo) {
        if (idx == books.length)
            return height;

        if (memo[idx][currWidth] != null)
            return memo[idx][currWidth];

        int inThisRow = Integer.MAX_VALUE;
        int inNextRow = Integer.MAX_VALUE;
        if (currWidth + books[idx][0] <= shelfWidth) {
            inThisRow = recur(idx + 1, currWidth + books[idx][0], Math.max(height, books[idx][1]), books, shelfWidth,
                    memo);
        }

        inNextRow = recur(idx + 1, books[idx][0], books[idx][1], books, shelfWidth, memo) + height;

        return memo[idx][currWidth] = Math.min(inNextRow, inThisRow);

    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer[][] memo = new Integer[books.length + 1][shelfWidth + 1];
        return recur(0, 0, 0, books, shelfWidth, memo);
    }
}