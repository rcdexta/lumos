package misc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StringIterator {

    String[] characters;
    Integer[] counter;
    int position = 0;

    public StringIterator(String compressedString) {
        characters = compressedString.split("\\d+");
        String[] counts = compressedString.split("[a-zA-Z]+");
        List<Integer> counterList = IntStream.range(1, counts.length).mapToObj(i -> Integer.parseInt(counts[i])).collect(Collectors.toList());
        counter = counterList.toArray(new Integer[]{});
    }

    public char next() {
        if (hasNext()) {
            if (counter[position] == 0) {
                position++;
            }
            counter[position]--;
            return characters[position].charAt(0);
        }
        return ' ';
    }

    public boolean hasNext() {
        return counter.length > 0 && (counter[position] > 0 || position < characters.length - 1);
    }
}
