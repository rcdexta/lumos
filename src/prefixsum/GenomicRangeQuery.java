package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        Map<Character, Integer> impactFactor = new HashMap<>();
        impactFactor.put('A', 1);
        impactFactor.put('C', 2);
        impactFactor.put('G', 3);
        impactFactor.put('T', 4);

        int[] score = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            score[i] = impactFactor.get(c);
        }

        int[] results = new int[P.length];
        for (int j = 0; j < P.length; j++) {
            int start = P[j];
            int end = Q[j];
            int min = Integer.MAX_VALUE;
            for (int k = start; k <= end; k++) {
                min = Math.min(min, score[k]);
            }
            results[j] = min;
        }
        return results;
    }
}
