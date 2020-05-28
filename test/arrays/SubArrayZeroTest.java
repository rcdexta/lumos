package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubArrayZeroTest {

    @Test
    void solve() {
        SubArrayZero subject = new SubArrayZero();
        assertTrue(subject.solve(new int[]{6, 4, -7, 3, 12, 9}));
        assertTrue(subject.solve(new int[]{4, -7, 3, 12, 9}));
        assertTrue(subject.solve(new int[]{1, 2, 3, 4, -10}));
        assertTrue(subject.solve(new int[]{0, 0, 0, 0}));
    }
}