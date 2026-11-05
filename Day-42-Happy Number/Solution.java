import java.util.HashSet;

class Solution {

    public boolean isHappy(int n) {

        // HashSet: pehle se aaye numbers ko store karega
        // Isse cycle detect kar sakte hain
        HashSet<Integer> set = new HashSet<>();

        // Jab tak number 1 nahi banta
        // aur number repeat nahi hota
        while (n != 1 && !set.contains(n)) {

            // Current number ko set mein store karo
            set.add(n);

            // Har digit ke square ka sum store karega
            int sum = 0;

            // Number ke sabhi digits process karo
            while (n > 0) {

                // Last digit nikalo
                int digit = n % 10;

                // Digit ka square calculate karke sum mein add karo
                sum = sum + (digit * digit);

                // Last digit remove karo
                n = n / 10;
            }

            // Naye number ko sum se update karo
            n = sum;
        }

        // Agar number 1 hai toh Happy Number
        // Otherwise cycle repeat hui hai
        return n == 1;
    }
}
