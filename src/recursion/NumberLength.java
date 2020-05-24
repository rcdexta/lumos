package recursion;

public class NumberLength {

    public static void main(String[] args) {
        int length = findLength(1234567);
        System.out.println(length);
    }

    private static int findLength(int num) {
        if (num == 0) return 0;

        return 1 + findLength(num / 10);
    }
}
