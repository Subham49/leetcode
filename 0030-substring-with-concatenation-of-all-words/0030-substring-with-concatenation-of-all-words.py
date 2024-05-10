class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        map = {}
        for word in words:
            if word in map: map[word] += 1
            else: map[word] = 1

        ans = []

        start, end = 0,0
        lenOfEachWord = len(words[0])
        total = lenOfEachWord * len(words)

        # print(lenOfEachWord, total)
        while end < len(s):
            if end - start + 1 == total:
                map1 = {}
                i = start

                while i <= end:
                    substringWord = s[i : i+lenOfEachWord]
                    if substringWord in map1: map1[substringWord] += 1
                    else: map1[substringWord] = 1
                    i += lenOfEachWord
               
                if map == map1: 
                    ans.append(start)
                start += 1
            end += 1

        return ans