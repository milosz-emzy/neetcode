package codility;

//https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
class BinaryGap {
    public int binaryGapCount(int n) {
        int count = 0;
        int max = 0;
        boolean isGap = false; // for case 1000000000
        while (n != 0) {
            if(n % 2 == 0 && isGap) {
                count++;
            } else {
                isGap = true;
                max = Math.max(count, max);
                count=0;
            }
            n = n / 2;
        }

        return max;
    }
}