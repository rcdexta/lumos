package recursion;

public class StringPermutations {

    public static void permutations(char[] array, int currentIndex) {
        if (currentIndex == array.length - 1) {
            System.out.println(array);
        }
       for(int i=currentIndex;i<array.length;i++) {
           swap(array, currentIndex, i);
           permutations(array, currentIndex+1);
           swap(array, currentIndex, i);
       }
    }

    public static void swap(char[] array, int i, int j) {
        char c;
        c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

    public static void main(String[] args) {

        char[] input = {'a', 'b', 'c'};
        permutations(input, 0);
    }
}
