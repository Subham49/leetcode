class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int i=0, j=0;

        int n = a.length;
        int m = b.length;
        while(i<n && j<m)
        {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(b[j]);
            // System.out.println(x+" "+y);
            if(x>y)
                return 1;
            else if(x<y)
                return -1;
            i++;
            j++;
        }
        while(i<n)
        {
            int x = Integer.parseInt(a[i++]);
            if(x!=0)
                return 1;
        }

        while(j<m)
        {
            int x = Integer.parseInt(b[j++]);
            if(x!=0)
                return -1;
        }
        return 0;
    }
}