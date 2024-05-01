class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        if word.find(ch) == -1: return word
        ind = word.index(ch)
        sb = word[:ind+1]
        sb = sb[::-1]
        return sb + word[ind+1:]