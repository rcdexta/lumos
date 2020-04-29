package counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermMissingElemTest {

    @Test
    void solution() {
        PermMissingElem subject = new PermMissingElem();
        int[] A = new int[]{2, 3, 1, 5};
        assertEquals(4, subject.solution(A));
        int[] X = new int[]{1, 2};
        assertEquals(3, subject.solution(X));
        int[] B = new int[]{2, 3, 1, 5, 4, 6, 8};
        assertEquals(7, subject.solution(B));
        int[] C = new int[]{1};
        assertEquals(2, subject.solution(C));
        int[] D = new int[]{};
        assertEquals(1, subject.solution(D));
    }

    @Test
    void perfTest() {
        int N = 1000000;
        int[] arr = new int[N-2];
        for (int i = 2; i < N; i++) {
            arr[i-2] = i;
        }
        assertEquals(1, new PermMissingElem().solution(arr));

    }
}