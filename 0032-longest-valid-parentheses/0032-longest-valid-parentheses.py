class Solution:
    def stackApproach(self, s: str) -> int:
        stack = [-1]
        ans = 0

        for i in range(len(s)):
            ch = s[i]
            if ch == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                ans = max(ans, i - stack[-1])

        return ans

    def withoutStackApproach(self, s: str) -> int:
        o, c = 0, 0
        ans = 0
        for i in range(len(s)):
            ch = s[i]
            if ch == '(':
                o += 1
            else:
                c += 1

            if o == c:
                ans = max(ans, o + c)
            elif c > o:
                o = c = 0

        o = c = 0
        for i in range(len(s) - 1, -1, -1):
            ch = s[i]
            if ch == '(':
                o += 1
            else:
                c += 1

            if o == c:
                ans = max(ans, o + c)
            elif c < o:
                o = c = 0

        return ans

    def longestValidParentheses(self, s: str) -> int:
        return self.stackApproach(s)
