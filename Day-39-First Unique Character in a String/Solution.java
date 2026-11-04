class Solution {
    public int firstUniqChar(String s) {

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (frequency[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
