/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] = new int[m][n];
        int row = m-1;
        int col = n-1;
        int sr = 0;
        int sc = 0;
        int c = 0, end = m*n;
        while(c<end)
        {
            for(int i=sc; i<=col && c<end; i++)
            {
                c++;
                if(head!=null)
                {
                    ans[sr][i] = head.val;
                    head = head.next;
                }
                else
                    ans[sr][i] = -1;
            }
            sr++;
            for(int i=sr; i<=row && c<end; i++)
            {
                c++;
                if(head!=null)
                {
                    ans[i][col] = head.val;
                    head = head.next;
                }
                else
                    ans[i][col] = -1;
            }
            col--;
            for(int i=col; i>=sc && c<end; i--)
            {
                c++;
                if(head!=null)
                {
                    ans[row][i] = head.val;
                    head = head.next;
                }
                else
                    ans[row][i] = -1;
            }
            row--;
            for(int i=row; i>=sr && c<end; i--)
            {
                c++;
                if(head!=null)
                {
                    ans[i][sc] = head.val;
                    head = head.next;
                }
                else
                    ans[i][sc] = -1;
            }
            sc++;
        }
        return ans;
    }
}