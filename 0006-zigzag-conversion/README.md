<h2><a href="https://leetcode.com/problems/zigzag-conversion/">6. Zigzag Conversion</a></h2><h3>Medium</h3><hr><div><p>The string <code>"PAYPALISHIRING"</code> is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)</p>

<pre>P   A   H   N
A P L S I I G
Y   I   R
</pre>

<p>And then read line by line: <code>"PAHNAPLSIIGYIR"</code></p>

<p>Write the code that will take a string and make this conversion given a number of rows:</p>

<pre>string convert(string s, int numRows);
</pre>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "PAYPALISHIRING", numRows = 3
<strong>Output:</strong> "PAHNAPLSIIGYIR"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "PAYPALISHIRING", numRows = 4
<strong>Output:</strong> "PINALSIGYAHRPI"
<strong>Explanation:</strong>
P     I    N
A   L S  I G
Y A   H R
P     I
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "A", numRows = 1
<strong>Output:</strong> "A"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists of English letters (lower-case and upper-case), <code>','</code> and <code>'.'</code>.</li>
	<li><code>1 &lt;= numRows &lt;= 1000</code></li>
</ul>
</div>

## Java
```java
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++)
        {
            list.add(new ArrayList<>());
        }
        int i=0, k=0;
        boolean flag = true;
        while(i<s.length())
        {
            if(flag)
            {
                while(i<s.length() && k<numRows)
                {
                    list.get(k).add(s.charAt(i++));
                    k++;
                }
                k = numRows-2;
            }
            else{
                while(i<s.length() && k>=0)
                {
                    list.get(k).add(s.charAt(i++));
                    k--;
                }
                k = 1;
            }
            flag = !flag;
        }
        StringBuilder ans = new StringBuilder();
        for(ArrayList<Character> str : list)
        {
            for(Character ch : str)
            {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
```

## Python
```python
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        lists = [[] for _ in range(numRows)]
        i, k = 0, 0
        flag = True

        while i < len(s):
            if flag:
                while i < len(s) and k < numRows:
                    lists[k].append(s[i])
                    i += 1
                    k += 1
                k = numRows - 2
            else:
                while i < len(s) and k >= 0:
                    lists[k].append(s[i])
                    i += 1
                    k -= 1
                k = 1
            flag = not flag

        ans = ''.join([''.join(row) for row in lists])
        return ans
```
