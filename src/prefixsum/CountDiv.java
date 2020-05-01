package prefixsum;

public class CountDiv {

    public int solution(int A, int B, int K) {
        int diff = B - A + 1;
        int i = diff / K;
        return i;
    }
}
