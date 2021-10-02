class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null)
        {
            return -1;
        }
        if(needle.isEmpty())
        {
            return 0;
        }
        else
            return haystack.indexOf(needle);
        
    }
}
