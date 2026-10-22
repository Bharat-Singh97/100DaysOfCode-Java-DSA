class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Step 1: Find the maximum pile size
        int maxPile = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > maxPile) {
                maxPile = piles[i];
            }
        }

        // Step 2: Define the search range
        int left = 1;
        int right = maxPile;

        // Step 3: Apply Binary Search
        while (left < right) {

            // Calculate the middle eating speed
            int mid = left + (right - left) / 2;

            // Use long to prevent overflow in total hours
            long totalHours = 0;

            // Calculate total hours at speed mid
            for (int i = 0; i < piles.length; i++) {

                // Ceiling division to calculate required hours
                totalHours += (piles[i] - 1) / mid + 1;
            }

            if (totalHours <= h) {

                // Speed is valid; try a smaller speed
                right = mid;

            } else {

                // Speed is too slow; increase the speed
                left = mid + 1;
            }
        }

        // The minimum valid speed
        return left;
    }
}
