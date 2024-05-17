class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        for string in strs:
            temp = string[:]
            string = ''.join(sorted(string))
            if string not in map: map[string] = []
            map[string].append(temp)
        
        ans = []
        for val in map.values(): ans.append(val)
        return ans