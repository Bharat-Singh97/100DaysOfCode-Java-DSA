class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxlength = 0;

        while(right < s.length()){

            char ch = s.charAt(right);

            if(!set.contains(ch)){
                set.add(ch);

                maxlength = Math.max(maxlength, right -left +1);

                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
        
    }
}
