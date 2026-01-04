class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {

            // Case 1: num = p^3
            int p = (int) Math.round(Math.cbrt(num));
            if (p * p * p == num && isPrime(p)) {
                totalSum += 1 + p + p * p + num;
                continue;
            }

            // Case 2: num = p * q
            for (int d = 2; d * d <= num; d++) {
                if (num % d == 0) {
                    int other = num / d;
                    if (d != other && isPrime(d) && isPrime(other)) {
                        totalSum += 1 + d + other + num;
                    }
                    break; // only first factor needed
                }
            }
        }

        return totalSum;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
