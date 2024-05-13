class Solution:
    def __init__(self):
        self.ans = []

    def fun(self, i, tar, a, lst):
        if tar == 0:
            self.ans.append(lst[:])
            return
        if tar < 0 or i == len(a):
            return
        lst.append(a[i])
        self.fun(i, tar - a[i], a, lst)
        lst.pop()
        self.fun(i + 1, tar, a, lst)

    def combinationSum(self, candidates, target):
        self.fun(0, target, candidates, [])
        return self.ans
