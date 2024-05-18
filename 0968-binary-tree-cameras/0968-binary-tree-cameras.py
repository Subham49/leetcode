# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.cam = 0

    def fun(self, root):
        if root is None:
            return 0
        l = self.fun(root.left)
        r = self.fun(root.right)

        if l == -1 or r == -1:  # left has no cam or right has no camera
            self.cam += 1
            return 1  # install camera
        if l == 1 or r == 1:  # left has cam or right has cam
            return 0
        return -1  # no camera cover

    def minCameraCover(self, root):
        return self.fun(root) == -1 and self.cam + 1 or self.cam