import java.util.HashSet;
import java.util.ArrayList;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Add nums1 elements into HashSet
        for (int num : nums1) {
            set.add(num);
        }

        // Step 2: Find common unique elements
        for (int num : nums2) {

            if (set.contains(num) && !result.contains(num)) {

                result.add(num);
            }
        }

        // Step 3: Convert ArrayList into int[]
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {

            answer[i] = result.get(i);
        }

        // Step 4: Return result
        return answer;
    }
}
